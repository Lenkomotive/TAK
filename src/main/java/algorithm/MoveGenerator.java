package algorithm;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import tak.Tak;
import utils.Coordinates;
import utils.PieceColor;
import utils.PruneNode;

import java.util.*;
import java.util.stream.Collectors;

public final class MoveGenerator {

    public static int TREE_DEPTH;
    public static final String BAKI = "ᴮᵃᵏᶤ ᶤˢ ᶢᵃʸ";

    public static PieceColor ourColor;
    public static PieceColor opponentColor;

    private static List<Tak.Direction> wallFlatteningDirections = new ArrayList<>();

    private static final Logger logger = LogManager.getLogger(MoveGenerator.class);
    public static Tak.GameTurn playSmartMove(Tak.GameState state) {
        printBoard(state);
        Tree tree = new Tree(state);
        logger.info("Created: 1 node | Depth: 0 | Level: MAX");
        //min
        tree.root.children.addAll(createAllPlaceNodes(tree.root, state, true));
        tree.root.children.addAll(createAllMoveNodes(tree.root, state, true));
        logger.info("Created: " + tree.root.children.size() + " nodes | Depth: 1 | Level: MIN");
        boolean min = false;


        List<Node> children = tree.root.children;
        for (int depth = 2; depth <= TREE_DEPTH ; depth++) {
            List<Node> newChildren = new ArrayList<>();
            int counter = 0;
            for(var child: children) {
                child.children.addAll(createAllPlaceNodes(child, child.currentState, min));
                child.children.addAll(createAllMoveNodes(child, child.currentState, min));
                newChildren.addAll(child.children);
                counter += child.children.size();
                System.out.print("\r Created " + counter +  " nodes! " + BAKI);
            }
            System.out.println();
            logger.info("Created: " + counter + " nodes | Depth: "+ depth + " | Level: "+ (min? "MIN":"MAX"));
            children = newChildren;
            min = !min;
        }
        Evaluator evaluator = new Evaluator();

        float MAX = 0.0f;
        float MIN = 0.0f;
        for(var child : children) {
            child.val = 0.0f;
            child.val = evaluator.getEvalCaptured(child.currentState, ourColor) + evaluator.getEvalComposition(child.currentState, ourColor);
            if(child.val > MAX) MAX = child.val;
            if(child.val < MIN) MIN = child.val;
        }

        PruneNode alphaBetaResult = PruningHelper.alphaBetaPrune(tree.root, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
        Node finalMove = alphaBetaResult.getNode();
        for (int i = 0; i < TREE_DEPTH - 1; i++) {
            finalMove = finalMove.parent;
        }

        logger.info("AlphaBetaPruning evaluation: " + alphaBetaResult.getVal());
        logger.info("MAX: "  + MAX);
        logger.info("MIN: "  + MIN);
        return finalMove.gameTurn;
    }


    public static List<Node> createAllPlaceNodes(Node parent, Tak.GameState state, boolean min) {
        // place actions are only valid on empty fields
        List<Node> children = new ArrayList<>();
        for(Tak.PieceType pieceType : Tak.PieceType.values()) {
            if(pieceType == Tak.PieceType.UNRECOGNIZED) continue;
            for (int i = 0; i < state.getBoardList().size(); i++) {
                // if field is not empty we can not place a piece there
                if (state.getBoardList().get(i).getPiecesCount() != 0) continue;
                // copy the old values in order to update and assign to new state
                List<Integer> newRemainingStonesList = new ArrayList<>(state.getRemainingStonesList());
                List<Integer> newRemainingCapStonesList = new ArrayList<>(state.getRemainingCapstonesList());
                int remainingStoneIndex = min? ourColor.ordinal(): opponentColor.ordinal();
                switch (pieceType) {
                    case FLAT_STONE:
                    case STANDING_STONE:
                        int stoneCount = state.getRemainingStonesList().get(remainingStoneIndex);
                        if(stoneCount == 0) continue; // if no stones left we can not make a move and therefore no new child
                        newRemainingStonesList.set(remainingStoneIndex, stoneCount - 1); // otherwise subtract one stone for new state
                        break;
                    case CAPSTONE:
                        stoneCount = state.getRemainingCapstonesList().get(remainingStoneIndex);
                        if(stoneCount == 0) continue; // if no capstones left we can not make a move and therefore no new child
                        newRemainingCapStonesList.set(remainingStoneIndex, stoneCount - 1); // otherwise subtract one stone for new state
                        break;
                }

                // in order to later know which turn was played, we create a GameTurn object to save it in the node
                Tak.PlaceAction placeAction = createPlaceAction(pieceType);
                Tak.GameTurn gameTurn = createPlaceGameTurn(state.getBoardLength(), i, placeAction);

                // since a move was played, we need to update the board as well
                boolean secondPlayerOwned = getSecondPlayerOwned(min);
                Tak.Piece newPiece = createPiece(pieceType, secondPlayerOwned);
                Tak.Pile newPile = Tak.Pile.newBuilder().addPieces(newPiece).build();
                List<Tak.Pile> newBoard = new ArrayList<>(state.getBoardList());
                newBoard.set(i, newPile);

                // now we can create a new state, and from this new state the next moves can be played
                Tak.GameState newGameState = createNewGameState(state.getBoardLength(),
                        newBoard, newRemainingStonesList, newRemainingCapStonesList);
                children.add(new Node(parent, min, gameTurn, newGameState));
            }
        }
        return children;
    }

    public static List<Node> createAllMoveNodes(Node parent, Tak.GameState state, boolean min) {
        List<Node> children = new ArrayList<>();
        for (int i = 0; i < state.getBoardList().size(); i++) {
            Tak.Pile currentPile = state.getBoardList().get(i);
            // if there is no piece placed, player can not move it
            if (currentPile.getPiecesCount() == 0) continue;
            // if pile is not under control, player can not move it
            if (!pileIsUnderControl(currentPile, min)) continue;

            Coordinates coordinates = translateIndexToCoordinates(state.getBoardLength(), i);
            // if top piece is of type CAPSTONE- it will be able to flatten walls
            Tak.PieceType topPiece = Tak.PieceType.FLAT_STONE; //currentPile.getPiecesList().get(currentPile.getPiecesCount() - 1).getType();
            Map<Tak.Direction, Integer> directionsMap = getNOSWFreeFields(coordinates, state, topPiece);
            // the carryLimit can be at maximum the boardLength or less if pile has fewer pieces
            int carryLimit = Math.min(currentPile.getPiecesCount(), state.getBoardLength());
            // create Nodes for all directions
            for(var direction: Tak.Direction.values()) {
                if(direction == Tak.Direction.UNRECOGNIZED) continue;
                // for every direction, the free fields were calculated
                int freeFieldCount = directionsMap.get(direction);
                // if the top piece is a Capstone, and there is a wall which can be flattend, this counts as one more free field
                // and we need to filter all drops of that length to only have 1 as last element: 2,2,1 or 2,3,1
                // because Capstone needs to be last piece
                boolean flatteningWall = topPiece == Tak.PieceType.CAPSTONE && wallFlatteningDirections.contains(direction);
                // now we need to consider all possible drops in given direction for up to freeFieldCount fields
                List<List<Integer>> allPossibleDrops = getAllPossibleDrops(freeFieldCount, carryLimit, flatteningWall);
                // from the calculated drops we can create moveActions
                List<Tak.MoveAction> moveActions = createMoveActionsFromDrops(allPossibleDrops, direction);
                for(var moveAction: moveActions) {
                    Tak.GameTurn gameTurn = createMoveGameTurn(coordinates, moveAction);
                    List<Tak.Pile> newBoard = updateBoardWithMoveAction(state, moveAction, i);

                    // now we can create a new state, and from this new state the next moves can be played
                    Tak.GameState newGameState = createNewGameState(state.getBoardLength(),
                            newBoard, state.getRemainingStonesList(), state.getRemainingCapstonesList());

                    children.add(new Node(parent, min, gameTurn, newGameState));
                }
            }
            wallFlatteningDirections.clear();
        }

        return children;
    }

    private static List<Tak.Pile> updateBoardWithMoveAction(Tak.GameState oldState, Tak.MoveAction moveAction, int startIndex) {
        List<Tak.Pile> newBoard = new ArrayList<>(oldState.getBoardList());
        // extract the piecesList which is worked on to split it
        var currentPiecesList =  newBoard.get(startIndex).getPiecesList();
        // count how many pieces will be moved so the original pile can be split
        int numberOfMovingPieces = 0;
        for(var drop: moveAction.getDropsList()) numberOfMovingPieces+=drop;
        // this is what stays at the original index
        var leftOverPieces = currentPiecesList.subList(0, currentPiecesList.size() - numberOfMovingPieces);
        Tak.Pile leftOverPile = Tak.Pile.newBuilder().addAllPieces(leftOverPieces).build();
        newBoard.set(startIndex, leftOverPile);
        // the movingPieces have to be split in the given direction according to the drops
        var movingPieces = currentPiecesList.subList(currentPiecesList.size() - numberOfMovingPieces, currentPiecesList.size());
        switch (moveAction.getDirection()) {
            case NORTH -> updateBoardInNorthDirection(oldState, startIndex ,movingPieces, newBoard, moveAction.getDropsList());
            case EAST -> updateBoardInEastDirection(oldState, startIndex ,movingPieces, newBoard, moveAction.getDropsList());
            case SOUTH -> updateBoardInSouthDirection(oldState, startIndex ,movingPieces, newBoard, moveAction.getDropsList());
            case WEST -> updateBoardInWestDirection(oldState, startIndex ,movingPieces, newBoard, moveAction.getDropsList());
        }
        return newBoard;
    }

    private static void updateBoardInNorthDirection(Tak.GameState oldState, int startIndex, List<Tak.Piece> movingPieces,
                                                    List<Tak.Pile> newBoard, List<Integer> drops) {
        Coordinates startCoordinates = translateIndexToCoordinates(oldState.getBoardLength(), startIndex);
        int movingPiecesIndex = 0;
        int x = startCoordinates.X;
        int y = startCoordinates.Y - 1;
        for(var drop: drops) {
            movingPiecesIndex = addDropsToBoard(oldState, movingPieces, newBoard, oldState.getBoardList(), movingPiecesIndex, x, y, drop);
            y--;
        }
    }

    private static void updateBoardInEastDirection(Tak.GameState oldState, int startIndex, List<Tak.Piece> movingPieces, List<Tak.Pile> newBoard, List<Integer> drops) {
        Coordinates startCoordinates = translateIndexToCoordinates(oldState.getBoardLength(), startIndex);
        int movingPiecesIndex = 0;
        int x = startCoordinates.X + 1;
        int y = startCoordinates.Y;
        for(var drop: drops) {
            movingPiecesIndex = addDropsToBoard(oldState, movingPieces, newBoard, oldState.getBoardList(), movingPiecesIndex, x, y, drop);
            x++;
        }
    }

    private static void updateBoardInSouthDirection(Tak.GameState oldState, int startIndex, List<Tak.Piece> movingPieces, List<Tak.Pile> newBoard, List<Integer> drops) {
        Coordinates startCoordinates = translateIndexToCoordinates(oldState.getBoardLength(), startIndex);
        int movingPiecesIndex = 0;
        int x = startCoordinates.X;
        int y = startCoordinates.Y + 1;
        for(var drop: drops) {
            movingPiecesIndex = addDropsToBoard(oldState, movingPieces, newBoard, oldState.getBoardList(), movingPiecesIndex, x, y, drop);
            y++;
        }
    }

    private static void updateBoardInWestDirection(Tak.GameState oldState, int startIndex, List<Tak.Piece> movingPieces, List<Tak.Pile> newBoard, List<Integer> drops) {
        Coordinates startCoordinates = translateIndexToCoordinates(oldState.getBoardLength(), startIndex);
        int movingPiecesIndex = 0;
        int x = startCoordinates.X - 1;
        int y = startCoordinates.Y;
        for(var drop: drops) {
            movingPiecesIndex = addDropsToBoard(oldState, movingPieces, newBoard, oldState.getBoardList(), movingPiecesIndex, x, y, drop);
            x--;
        }
    }

    private static int addDropsToBoard(Tak.GameState oldState, List<Tak.Piece> movingPieces, List<Tak.Pile> newBoard, List<Tak.Pile> oldBoard, int movingPiecesIndex, int x, int y, Integer drop) {
        int nextIndex = translateCoordinateToIndex(oldState.getBoardLength(), new Coordinates(x, y));
        List<Tak.Piece> updatedPile = new ArrayList<>(oldBoard.get(nextIndex).getPiecesList());
        for(int i = 0; i < drop; i++) {
            updatedPile.add(movingPieces.get(movingPiecesIndex));
            movingPiecesIndex++;
        }
        newBoard.set(nextIndex, Tak.Pile.newBuilder().addAllPieces(updatedPile).build());
        return movingPiecesIndex;
    }

    private static Tak.GameTurn createMoveGameTurn(Coordinates coordinates, Tak.MoveAction moveAction) {
            return Tak.GameTurn.newBuilder().
                    setX(coordinates.X).
                    setY(coordinates.Y)
                    .setMove(moveAction)
                    .build();
    }

    private static List<Tak.MoveAction> createMoveActionsFromDrops(List<List<Integer>> allPossibleDrops, Tak.Direction direction) {
        List<Tak.MoveAction> moveActions = new ArrayList<>();
        for(var drop : allPossibleDrops) {
            Tak.MoveAction moveAction = Tak.MoveAction.newBuilder()
                    .addAllDrops(drop)
                    .setDirection(direction)
                    .build();
            moveActions.add(moveAction);
        }
        return moveActions;
    }

    public static Map<Tak.Direction, Integer> getNOSWFreeFields(Coordinates coordinates, Tak.GameState state, Tak.PieceType topPiece) {
        Map<Tak.Direction, Integer> directions = new HashMap<>();

        int maxMoveToNorth = 0;
        int maxMoveToEast = 0;
        int maxMoveToSouth = 0;
        int maxMoveToWest = 0;

        for ( int y = coordinates.Y - 1; y >= 0; y-- ) {
            int currentIndex = translateCoordinateToIndex(state.getBoardLength(), new Coordinates(coordinates.X, y));
            List<Tak.Piece> pile = state.getBoardList().get(currentIndex).getPiecesList();
            if ( checkForCapstoneBlocker(pile) ) break;
            if ( checkForWallBlocker(pile) ) {
                if(topPiece == Tak.PieceType.CAPSTONE) maxMoveToNorth++;
                wallFlatteningDirections.add(Tak.Direction.NORTH);
                break;
            }
            maxMoveToNorth++;
        }

        for ( int y = coordinates.Y + 1; y < state.getBoardLength(); y++ ) {
            int currentIndex = translateCoordinateToIndex(state.getBoardLength(), new Coordinates(coordinates.X, y));
            List<Tak.Piece> pile = state.getBoardList().get(currentIndex).getPiecesList();
            if ( checkForCapstoneBlocker(pile) ) break;
            if ( checkForWallBlocker(pile) ) {
                if(topPiece == Tak.PieceType.CAPSTONE) maxMoveToSouth++;
                wallFlatteningDirections.add(Tak.Direction.SOUTH);
                break;
            }
            maxMoveToSouth++;
        }

        for ( int x = coordinates.X + 1; x < state.getBoardLength(); x++ ) {
            int currentIndex = translateCoordinateToIndex(state.getBoardLength(), new Coordinates(x, coordinates.Y));
            List<Tak.Piece> pile = state.getBoardList().get(currentIndex).getPiecesList();
            if ( checkForCapstoneBlocker(pile) ) break;
            if ( checkForWallBlocker(pile) ) {
                if(topPiece == Tak.PieceType.CAPSTONE) maxMoveToEast++;
                wallFlatteningDirections.add(Tak.Direction.EAST);
                break;
            }
            maxMoveToEast++;
        }

        for ( int x = coordinates.X - 1; x >= 0; x-- ) {
            int currentIndex = translateCoordinateToIndex(state.getBoardLength(), new Coordinates(x, coordinates.Y));
            List<Tak.Piece> pile = state.getBoardList().get(currentIndex).getPiecesList();
            if ( checkForCapstoneBlocker(pile) ) break;
            if ( checkForWallBlocker(pile) ) {
                if(topPiece == Tak.PieceType.CAPSTONE) maxMoveToWest++;
                wallFlatteningDirections.add(Tak.Direction.WEST);
                break;
            }
            maxMoveToWest++;
        }

        directions.put(Tak.Direction.NORTH, maxMoveToNorth);
        directions.put(Tak.Direction.EAST, maxMoveToEast);
        directions.put(Tak.Direction.SOUTH, maxMoveToSouth);
        directions.put(Tak.Direction.WEST, maxMoveToWest);
        return directions;
    }

    private static boolean checkForCapstoneBlocker(List<Tak.Piece> pile) {
        if ( pile.size() != 0) {
            return  pile.get(pile.size() - 1).getType() == Tak.PieceType.CAPSTONE;
        }
        return false;
    }

    private static boolean checkForWallBlocker(List<Tak.Piece> pile) {
        if ( pile.size() != 0) {
            return  pile.get(pile.size() - 1).getType() == Tak.PieceType.STANDING_STONE;
        }
        return false;
    }

    private static int translateCoordinateToIndex(int boardLength, Coordinates coordinates) {
        return coordinates.Y * boardLength + coordinates.X;
    }


    public static boolean pileIsUnderControl(Tak.Pile pile, boolean min) {
        Tak.Piece top = pile.getPieces(pile.getPiecesCount() - 1);
        return  top.getSecondPlayerOwned() == getSecondPlayerOwned(min);
    }

    private static boolean getSecondPlayerOwned(boolean min) {
        // at min level we make moves, at max (!min) level, opponent makes moves
        boolean secondPlayerOwned = false;
        if((min && ourColor == PieceColor.WHITE) || (!min && ourColor == PieceColor.BLACK)) {
            secondPlayerOwned = false;
        }
        if((min && ourColor == PieceColor.BLACK) || (!min && ourColor == PieceColor.WHITE)) {
            secondPlayerOwned = true;
        }
        return secondPlayerOwned;
    }

    private static Tak.PlaceAction createPlaceAction(Tak.PieceType type) {
        return Tak.PlaceAction.newBuilder()
                .setPiece(type)
                .build();
    }

    private static Tak.GameState createNewGameState(int boardLength, List<Tak.Pile> newBoard,
                    List<Integer> remainingStonesList, List<Integer> remainingCapstonesList) {
        return Tak.GameState.newBuilder()
                .setBoardLength(boardLength)
                .addAllBoard(newBoard)
                .addAllRemainingStones(remainingStonesList)
                .addAllRemainingCapstones(remainingCapstonesList)
                .build();
    }

    private static Tak.Piece createPiece(Tak.PieceType pieceType, boolean min) {
        return Tak.Piece.newBuilder().
                setType(pieceType)
                .setSecondPlayerOwned(min)
                .build();
    }

    private static Tak.GameTurn createPlaceGameTurn(int boardLength, int index, Tak.PlaceAction placeAction) {
        Coordinates coordinates = translateIndexToCoordinates(boardLength, index);
        return Tak.GameTurn.newBuilder()
                .setX(coordinates.X)
                .setY(coordinates.Y)
                .setPlace(placeAction)
                .build();
    }

    public static Tak.GameTurn playValidPlaceMove(Tak.GameState state) {
        int freeFieldIndex = findFirstFreeField(state.getBoardList());
        Tak.PlaceAction placeAction = Tak.PlaceAction.newBuilder().setPiece(Tak.PieceType.FLAT_STONE).build();
        return createPlaceGameTurn(state.getBoardLength(), freeFieldIndex, placeAction);
    }

    private static int findFirstFreeField(List<Tak.Pile> board) {
        for (int i = 0; i < board.size(); i++) {
            if(board.get(i).getPiecesList().size() == 0) {
                return i;
            }
        }
        logger.error("This should never be reached!");
        return -1;
    }
    public static Coordinates translateIndexToCoordinates(int boardLength, int index) {
        Coordinates coordinates = new Coordinates();
        coordinates.X = index % boardLength;
        coordinates.Y = index / boardLength;
        return coordinates;
    }

    public static List<List<Integer>> getAllPossibleDrops(int fieldCount, int carryLimit, boolean flatteningWall) {
        List<List<Integer>> allPossibleDrops = new ArrayList<>();
        for(int pieceCount = 1; pieceCount <= carryLimit; pieceCount++) {
            List<List<Integer>> partitions = PartitionHelper.getAllPartitions(pieceCount);
            List<List<Integer>> permutations = new ArrayList<>();
            partitions.forEach(e -> permutations.addAll(PermutationHelper.permute(e)));
            permutations.add(Collections.singletonList(pieceCount));
            var drops = permutations.stream().filter(perm -> perm.size() <= fieldCount).collect(Collectors.toList());
            allPossibleDrops.addAll(drops);
        }
        List<List<Integer>> filteredDrops = new ArrayList<>();
        for(var drop: allPossibleDrops) {
            if(drop.size() == fieldCount && drop.get(drop.size() - 1) != 1) continue;
            filteredDrops.add(drop);
        }
        return filteredDrops;
    }

    private static void printBoard(Tak.GameState state) {
        String boardStr = "";

        for (var pile: state.getBoardList()) {
            if(pile.getPiecesCount() == 0) {
                boardStr += "_,";
            }
            else {
                Tak.Piece piece = pile.getPieces(pile.getPiecesCount() -1);
                String top = "W";
                if(piece.getSecondPlayerOwned()) {
                    top = "B";
                }
                boardStr += top + ",";

            }
        }
       logger.info(boardStr.substring(0,boardStr.length()-3) + " stones:" + state.getRemainingStonesList());
    }

    // place opponents piece in corner
    public static Tak.GameTurn playFirstMove(Tak.GameState state) {
        int index = 0;
        if(state.getBoardList().get(0).getPiecesCount() != 0) {
            index = state.getBoardCount() - 1;
        }
        Tak.PlaceAction placeAction = Tak.PlaceAction.newBuilder().setPiece(Tak.PieceType.FLAT_STONE).build();
        return createPlaceGameTurn(state.getBoardLength(), index, placeAction);
    }
}




