import algorithm.MinMax;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tak.Tak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveGameTurnsTests {
    @Test
    public void calculateDirectionTest3x3_1() {
        int expectedChildren = 12;
        int boardLength = 4;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(0, getCapStonePile5());
        Tak.GameState gameState = createGameState(boardLength, board);

        var children = MinMax.createAllMoveNodes(null, gameState, true);

        Assertions.assertEquals(12,children.size());
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

    private Tak.Pile getCapStonePile5() {
        return Tak.Pile.newBuilder()
                .addPieces(getFlatStone())
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
