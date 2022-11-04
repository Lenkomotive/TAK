import algorithm.MinMax;
import org.junit.jupiter.api.Test;
import tak.Tak;
import utils.Coordinates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveGameTurnsTests {
    @Test
    public void calculateDirectionTest3x3_1() {
        int boardLength = 5;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(1, getCapStonePile());
        board.set(5, getStandingStonePile());
        board.set(7, getStandingStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(1, 1);
        MinMax.createAllMoveNodes(null, gameState, true);

        }




    private List<Tak.Pile> createBoard(int boardLength) {
        List<Tak.Pile> board = new ArrayList<>();
        for (int i = 0; i < boardLength * boardLength; i++) {
            board.add(Tak.Pile.newBuilder().build());
        }
        return board;
    }

    private Tak.GameState createGameState(int boardLength, List<Tak.Pile> board) {
        return Tak.GameState.newBuilder()
                .setBoardLength(boardLength)
                .addAllBoard(board)
                .build();
    }

    private Map<Tak.Direction, Integer> createExpectedDirectionMap(int n, int e, int s, int w) {
        Map<Tak.Direction, Integer> expected = new HashMap<>();
        expected.put(Tak.Direction.NORTH, n);
        expected.put(Tak.Direction.EAST, e);
        expected.put(Tak.Direction.SOUTH, s);
        expected.put(Tak.Direction.WEST, w);
        return expected;
    }

    private Tak.Pile getStandingStonePile() {
        return Tak.Pile.newBuilder()
                .addPieces(getFlatStone())
                .addPieces(getFlatStone())
                .addPieces(getFlatStone())
                .addPieces(getStandingStone())
                .build();
    }

    private Tak.Pile getCapStonePile() {
        return Tak.Pile.newBuilder()
                .addPieces(getFlatStone())
                .addPieces(getFlatStone())
                .addPieces(getFlatStone())
                .addPieces(getCapStone())
                .build();
    }

    private Tak.Piece getFlatStone() {
        return  Tak.Piece.newBuilder().setType(Tak.PieceType.FLAT_STONE).build();
    }

    private Tak.Piece getCapStone() {
        return  Tak.Piece.newBuilder().setType(Tak.PieceType.CAPSTONE).build();
    }

    private Tak.Piece getStandingStone() {
        return  Tak.Piece.newBuilder().setType(Tak.PieceType.STANDING_STONE).build();
    }
}
