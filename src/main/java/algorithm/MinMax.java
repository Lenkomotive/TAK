package algorithm;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import tak.Tak;
import utils.Coordinates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class MinMax {


    private static final Logger logger = LogManager.getLogger(MinMax.class);
    public static Tree constructTree(Tak.GameState state) {
        getAllPartitions(5,3);
        logger.info("Tree is in construction...");
        evaluate(state);
        return null;
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
}
