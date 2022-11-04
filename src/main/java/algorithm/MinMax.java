package algorithm;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import tak.Tak;
import utils.Coordinates;
import utils.PieceColor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class MinMax {


    public static PieceColor ourColor;

    private static final Logger logger = LogManager.getLogger(MinMax.class);
    public static Tak.GameTurn playSmartMove(Tak.GameState state) {
        Tree tree = new Tree(state);
        tree.root.children.addAll(createAllPlaceGameTurns(tree.root, state, true));
        tree.root.children.addAll(createAllMoveGameTurns(tree.root, state, true));
        return null;
    }


    public static List<Node> createAllPlaceGameTurns(Node parent, Tak.GameState state, boolean min) {
        // place actions are only valid on empty fields
        printBoard(state, 69);
        List<Node> children = new ArrayList<>();
        for(Tak.PieceType pieceType : Tak.PieceType.values()) {
            if(pieceType == Tak.PieceType.UNRECOGNIZED) continue;
            for (int i = 0; i < state.getBoardList().size(); i++) {
                // if field is not empty we can not place a piece there
                if (state.getBoardList().get(i).getPiecesCount() != 0) continue;
                // copy the old values in order to update and assign to new state
                List<Integer> newRemainingStonesList = new ArrayList<>(state.getRemainingStonesList());
                List<Integer> newRemainingCapStonesList = new ArrayList<>(state.getRemainingCapstonesList());
                switch (pieceType) {
                    case FLAT_STONE:
                    case STANDING_STONE:
                        int stoneCount = state.getRemainingStonesList().get(ourColor.ordinal());
                        if(stoneCount == 0) continue; // if no stones left we can not make a move and therefore no new child
                        newRemainingStonesList.set(ourColor.ordinal(), stoneCount - 1); // otherwise subtract one stone for new state
                        break;
                    case CAPSTONE:
                        stoneCount = state.getRemainingCapstonesList().get(ourColor.ordinal());
                        if(stoneCount == 0) continue; // if no capstones left we can not make a move and therefore no new child
                        newRemainingCapStonesList.set(ourColor.ordinal(), stoneCount - 1); // otherwise subtract one stone for new state
                        break;
                }

                // in order to later know which turn was played, we create a GameTurn object to save it in the node
                Tak.PlaceAction placeAction = createPlaceAction(pieceType);
                Tak.GameTurn gameTurn = createGameTurn(state.getBoardLength(), i, placeAction);

                // since a move was played, we need to update the board as well
                boolean secondPlayerOwned = getSecondPlayerOwned(min);
                Tak.Piece newPiece = createPiece(pieceType, secondPlayerOwned);
                Tak.Pile newPile = Tak.Pile.newBuilder().addPieces(newPiece).build();
                List<Tak.Pile> newBoard = new ArrayList<>(state.getBoardList());
                newBoard.set(i, newPile);

                // now we can create a new state, and from this new state the next moves can be played
                Tak.GameState newGameState = createNewGameState(state.getBoardLength(),
                        newBoard, newRemainingStonesList, newRemainingCapStonesList);
                printBoard(newGameState, i);
                children.add(new Node(parent, min, gameTurn, newGameState));
            }
        }
        return children;
    }

//    You can move one or more pieces in a stack that you control.
//    A stack can be any height, including just one piece. "Control" simply means that your piece is on top.
//    To move a stack, take as many as five pieces off the top (see Carry Limit, at right),
//    and move them in a straight line, dropping at least one piece off the bottom in each space along the way.
//    The pieces that you drop will cover any stacks that are in their path.
//    Capstones and standing stones block movement, because they cannot be covered.

    private static List<Node> createAllMoveGameTurns(Node parent, Tak.GameState state, boolean min) {
        for (int i = 0; i < state.getBoardList().size(); i++) {
            // if there is no piece placed, we can not move it
            if (state.getBoardList().get(i).getPiecesCount() == 0) continue;
            // if pile is not under our control, we can not move it
            if (!pileIsUnderControl(state.getBoardList().get(i), min)) continue;
            int carryLimit = state.getBoardLength();



        }


        return Collections.emptyList();
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

    private static Tak.GameTurn createGameTurn(int boardLength, int index, Tak.PlaceAction placeAction) {
        Coordinates coordinates = translateIndexToCoordinates(boardLength, index);
        return Tak.GameTurn.newBuilder()
                .setX(coordinates.X)
                .setY(coordinates.Y)
                .setPlace(placeAction)
                .build();
    }

    public static int evaluate(Tak.GameState state) {
        logger.info("Boards are evaluated...");
        return 0;
    }
    public static Tak.PlaceAction alphaBetaPrune(Tree tree) {
        logger.info("Pruning tree and calculating best move...");
        return null;
    }

    public static Tak.GameTurn playValidPlaceMove(Tak.GameState state) {
        int freeFieldIndex = findFirstFreeField(state.getBoardList());
        Tak.PlaceAction placeAction = Tak.PlaceAction.newBuilder().setPiece(Tak.PieceType.FLAT_STONE).build();
        return createGameTurn(state.getBoardLength(), freeFieldIndex, placeAction);
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
    public static Coordinates translateIndexToCoordinates(int boardLength, int freeFieldIndex) {
        Coordinates coordinates = new Coordinates();
        coordinates.X = freeFieldIndex % boardLength;
        coordinates.Y = freeFieldIndex / boardLength;
        return coordinates;
    }

    private static List<List<Integer>> getAllPartitions(int pieceCount, int fieldCount) {
        List<List<Integer>> partitions = PartitionHelper.getAllPartitions(pieceCount);
        List<List<Integer>> permutations = new ArrayList<>();
        partitions.forEach(e -> permutations.addAll(PermutationHelper.permute(e)));
        permutations.add(Collections.singletonList(pieceCount));
        return permutations.stream().filter(perm -> perm.size() <= fieldCount).collect(Collectors.toList());
    }

    private static void printBoard(Tak.GameState state, int index) {
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
       //logger.info(boardStr.substring(0,boardStr.length()-3) + " stones:" + state.getRemainingStonesList() + " index: " + index + " our color: " + ourColor);
    }

    // place opponents piece in corner
    public static Tak.GameTurn playFirstMove(Tak.GameState state) {
        int index = 0;
        if(state.getBoardList().get(0).getPiecesCount() != 0) {
            index = state.getBoardCount() - 1;
        }
        Tak.PlaceAction placeAction = Tak.PlaceAction.newBuilder().setPiece(Tak.PieceType.FLAT_STONE).build();
        return createGameTurn(state.getBoardLength(), index, placeAction);
    }
}
