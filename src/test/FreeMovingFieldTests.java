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
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest4x4_1() {
        int boardLength = 4;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(3,3);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(3,0,0,3);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest4x4_2() {
        int boardLength = 4;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(0,0);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(0,3,3,0);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }


    @Test
    public void calculateDirectionWithBlockersTest4x4_3() {
        int boardLength = 4;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(0,3);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(3,3,0,0);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest4x4_4() {
        int boardLength = 4;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(3,0);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(0,0,3,3);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest4x4_5() {
        int boardLength = 4;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(2, getCapStonePile());
        board.set(8, getStandingStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(0,0);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(0,1,1,0);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest4x4_6() {
        int boardLength = 4;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(0, getCapStonePile()); //yes does not make sense
        board.set(11, getStandingStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(1,2);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(2,1,1,1);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest4x4_7() {
        int boardLength = 4;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(9, getCapStonePile());
        board.set(6, getStandingStonePile());
        board.set(11, getStandingStonePile());
        board.set(14, getStandingStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(2,2);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(0,0,0,0);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest4x4_8() {
        int boardLength = 4;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(0, getCapStonePile());
        board.set(1, getCapStonePile());
        board.set(11, getStandingStonePile());
        board.set(14, getStandingStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(2,0);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(0,1,2,0);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest5x5_1() {
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
    public void calculateDirectionWithBlockersTest5x5_2() {
        int boardLength = 5;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(4, getCapStonePile());
        board.set(10, getCapStonePile());
        board.set(12, getStandingStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(4,2);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(1,0,2,1);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest5x5_3() {
        int boardLength = 5;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(0, getCapStonePile());
        board.set(6, getCapStonePile());
        board.set(20, getStandingStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(4,4);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(4,0,0,3);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest5x5_4() {
        int boardLength = 5;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(3, getCapStonePile());
        board.set(8, getCapStonePile());
        board.set(10, getStandingStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(3,2);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(0,1,2,2);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest5x5_5() {
        int boardLength = 5;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(10, getCapStonePile());
        board.set(1, getCapStonePile());
        board.set(2, getCapStonePile());
        board.set(3, getStandingStonePile());
        board.set(17, getStandingStonePile());
        board.set(23, getStandingStonePile());
        board.set(24, getStandingStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(0,4);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(1,2,0,0);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest6x6_1() {
        int boardLength = 6;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(0,0);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(0,5,5,0);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest6x6_2() {
        int boardLength = 6;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(5,0);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(0,0,5,5);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest6x6_3() {
        int boardLength = 6;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(12, getCapStonePile());
        board.set(27, getStandingStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(3,2);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(2,2,1,2);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest6x6_4() {
        int boardLength = 6;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(1, getCapStonePile());
        board.set(13, getStandingStonePile());
        board.set(29, getStandingStonePile());
        board.set(30, getStandingStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(1,4);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(1,3,1,1);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest6x6_5() {
        int boardLength = 6;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(30, getCapStonePile());
        board.set(11, getCapStonePile());
        board.set(0, getStandingStonePile());
        board.set(1, getStandingStonePile());
        board.set(2, getStandingStonePile());
        board.set(3, getStandingStonePile());
        board.set(4, getStandingStonePile());
        board.set(5, getStandingStonePile());
        board.set(6, getStandingStonePile());
        board.set(7, getStandingStonePile());
        board.set(8, getStandingStonePile());
        board.set(9, getStandingStonePile());
        board.set(10, getStandingStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(5,5);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(3,0,0,4);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest7x7_1() {
        int boardLength = 7;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(6,6);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(6,0,0,6);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest7x7_2() {
        int boardLength = 7;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(0,6);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(6,6,0,0);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest7x7_3() {
        int boardLength = 7;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(3, getCapStonePile());
        board.set(21, getCapStonePile());
        board.set(27, getStandingStonePile());
        board.set(45, getStandingStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(3,3);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(2,2,2,2);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest7x7_4() {
        int boardLength = 7;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(4, getCapStonePile());
        board.set(11, getCapStonePile());
        board.set(41, getStandingStonePile());
        board.set(46, getStandingStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(4,5);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(3,1,0,4);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest7x7_5() {
        int boardLength = 7;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(6, getCapStonePile());
        board.set(48, getCapStonePile());
        board.set(28, getStandingStonePile());
        board.set(29, getStandingStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(6,4);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(3,0,1,4);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest8x8_1() {
        int boardLength = 8;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(0,7);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(7,7,0,0);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest8x8_2() {
        int boardLength = 8;
        List<Tak.Pile> board = createBoard(boardLength);
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(7,0);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(0,0,7,7);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest8x8_3() {
        int boardLength = 8;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(4, getCapStonePile());
        board.set(32, getCapStonePile());
        board.set(33, getStandingStonePile());
        board.set(60, getStandingStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(4,4);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(3,3,2,2);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }

    @Test
    public void calculateDirectionWithBlockersTest8x8_4() {
        int boardLength = 8;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(1, getCapStonePile());
        board.set(40, getCapStonePile());
        board.set(57, getStandingStonePile());
        board.set(47, getStandingStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(1,5);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(4,5,1,0);
        Map<Tak.Direction, Integer> result = MinMax.getNOSWFreeFields(coordinates, gameState);

        Assertions.assertEquals(expected.get(Tak.Direction.NORTH), result.get(Tak.Direction.NORTH));
        Assertions.assertEquals(expected.get(Tak.Direction.EAST), result.get(Tak.Direction.EAST));
        Assertions.assertEquals(expected.get(Tak.Direction.SOUTH), result.get(Tak.Direction.SOUTH));
        Assertions.assertEquals(expected.get(Tak.Direction.WEST), result.get(Tak.Direction.WEST));
    }


    @Test
    public void calculateDirectionWithBlockersTest8x8_5() {
        int boardLength = 8;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(5, getCapStonePile());
        board.set(36, getCapStonePile());
        board.set(8, getStandingStonePile());
        board.set(9, getStandingStonePile());
        board.set(10, getStandingStonePile());
        board.set(11, getStandingStonePile());
        board.set(12, getStandingStonePile());
        board.set(13, getStandingStonePile());
        board.set(53, getStandingStonePile());
        board.set(61, getStandingStonePile());
        Tak.GameState gameState = createGameState(boardLength, board);
        Coordinates coordinates = new Coordinates(5,4);
        Map<Tak.Direction, Integer> expected = createExpectedDirectionMap(2,2,1,0);
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
