import algorithm.MinMax;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tak.Tak;
import utils.Coordinates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreeMovingFieldTests {
    @Test
    public void calculateDirectionTest3x3_1() {
        int boardLength = 3;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(1, 1);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(1,1,1,1);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionTest3x3_2() {
        int boardLength = 3;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(0, 0);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(0,2,2,0);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionTest3x3_3() {
        int boardLength = 3;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(0, 1);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(1,2,1,0);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionTest3x3_4() {
        int boardLength = 3;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(2, 1);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(1,0,1,2);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionTest4x4_1() {
        int boardLength = 4;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(0, 0);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(0,3,3,0);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionTest4x4_2() {
        int boardLength = 4;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(1, 1);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(1,2,2,1);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionTest4x4_3() {
        int boardLength = 4;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(2, 3);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(3,1,0,2);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionTest4x4_4() {
        int boardLength = 4;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(3, 1);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(1,0,2,3);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionTest5x5_1() {
        int boardLength = 5;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(0,0);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(0,4,4,0);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionTest5x5_2() {
        int boardLength = 5;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(2,2);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(2,2,2,2);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionTest5x5_3() {
        int boardLength = 5;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(4,3);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(3,0,1,4);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionTest5x5_4() {
        int boardLength = 5;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(1,1);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(1,3,3,1);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionTest6x6_1() {
        int boardLength = 6;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(0,5);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(5,5,0,0);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionTest6x6_2() {
        int boardLength = 6;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(3,3);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(3,2,2,3);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionTest6x6_3() {
        int boardLength = 6;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(3,1);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(1,2,4,3);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionTest6x6_4() {
        int boardLength = 6;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(4,5);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(5,1,0,4);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionTest8x8_1() {
        int boardLength = 8;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(5,5);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(5,2,2,5);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionTest8x8_2() {
        int boardLength = 8;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(7,7);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(7,0,0,7);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionTest8x8_3() {
        int boardLength = 8;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(2,3);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(3,5,4,2);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionTest8x8_4() {
        int boardLength = 8;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(3,7);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(7,4,0,3);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest3x3_1() {
        int boardLength = 3;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(2, getCapStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(0,0);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(0,1,2,0);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest3x3_2() {
        int boardLength = 3;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(5, getCapStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(1,1);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(1,0,1,1);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest3x3_3() {
        int boardLength = 3;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(3, getCapStonePile());
        board.set(7, getStandingStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(0,2);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(0,0,0,0);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest3x3_4() {
        int boardLength = 3;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(1, getCapStonePile());
        board.set(5, getStandingStonePile());
        board.set(7, getStandingStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(1,1);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(0,0,0,1);

        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest3x3_5() {
        int boardLength = 3;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(1, getCapStonePile());
        board.set(2, getStandingStonePile());
        board.set(7, getStandingStonePile());
        board.set(8, getStandingStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(2,1);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(0,0,0,2);
        //alooooo
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
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
