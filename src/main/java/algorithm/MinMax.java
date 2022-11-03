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
    public static Tree constructTree(Tak.GameState state) {
        Tree tree = new Tree(state);
        tree.root.children.addAll(getAllFlatStonePlaceAction(tree.root, state, true));
        logger.info("Tree is in construction...");
        return null;
    }

    public static List<Node> getAllFlatStonePlaceAction(Node parent, Tak.GameState state, boolean min) {
        Tak.PlaceAction placeAction = Tak.PlaceAction.newBuilder()
                .setPiece(Tak.PieceType.FLAT_STONE)
                .build();
        List<Node> children = new ArrayList<>();

        printBoard(state, 0, true);
        var board = state.getBoardList();

        for (int i = 0; i < board.size(); i++) {
            if (board.get(i).getPiecesCount() == 0) {
                Tak.GameTurn gameTurn = createGameTurn(state.getBoardLength(), i, placeAction);

                Tak.Piece newPiece = createPiece(Tak.PieceType.FLAT_STONE, !min);

                Tak.Pile newPile = Tak.Pile.newBuilder().addPieces(newPiece).build();

                List<Tak.Pile> newBoard = new ArrayList<>(state.getBoardList());
                newBoard.add(i,newPile);

                List<Integer> newRemainingStonesList = new ArrayList<>(state.getRemainingStonesList());
                int newRemainingStonesCount = state.getRemainingStonesList().get(ourColor.ordinal()) - 1;
                newRemainingStonesList.set(ourColor.ordinal(), newRemainingStonesCount);
                Tak.GameState newGameState = createNewGameState(state.getBoardLength(),
                        newBoard, newRemainingStonesList, state.getRemainingCapstonesList());

                children.add(new Node(parent, min, gameTurn, newGameState));
                printBoard(newGameState, i, false);
            }
        }
        return children;
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
        List<Tak.Pile> board = state.getBoardList();
        int freeFieldIndex = findFirstFreeField(board);
        Coordinates coordinates = translateIndexToCoordinates(state.getBoardLength(), freeFieldIndex);
        Tak.PieceType pieceType = Tak.PieceType.FLAT_STONE;
        Tak.PlaceAction placeAction = Tak.PlaceAction.newBuilder().setPiece(pieceType).build();

        return Tak.GameTurn.newBuilder()
                .setX(coordinates.X)
                .setY(coordinates.Y)
                .setPlace(placeAction)
                .build();
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
    private static Coordinates translateIndexToCoordinates(int boardLength, int freeFieldIndex) {
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

    private static void printBoard(Tak.GameState state, int index, boolean fuck) {
        String boardStr = "";
        if(fuck) {
            boardStr += "_,";
        }
        for (var pile: state.getBoardList()) {
            if(pile.getPiecesCount() == 0) {
                boardStr += "_,";
            }
            else {
                Tak.Piece piece = pile.getPieces(pile.getPiecesCount() -1);
                String top = "";
                if(piece.getSecondPlayerOwned()) {
                    top = "W";
                    if(ourColor == PieceColor.WHITE) {
                        top = "B";
                    }
                } else {
                    top = "B";
                    if(ourColor == PieceColor.WHITE) {
                        top = "W";
                    }
                }
                boardStr += top + ",";

            }
        }
       // logger.info(boardStr.substring(0,boardStr.length()-3) + " stones:" + state.getRemainingStonesList() + " index: " + index + " our color: " + ourColor);
    }
}
