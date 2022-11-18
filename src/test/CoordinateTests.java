import algorithm.MoveGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Coordinates;

public class CoordinateTests {

    @Test
    void givenIndexAndBoardLength1() {
        int index = 0;
        int boardLength = 3;
        Coordinates expected = new Coordinates();
        expected.X = 0;
        expected.Y = 0;

        Coordinates result = MoveGenerator.translateIndexToCoordinates(boardLength, index);

        Assertions.assertEquals(expected.X, result.X);
        Assertions.assertEquals(expected.Y, result.Y);
    }

    @Test
    void givenIndexAndBoardLength2() {
        int index = 4;
        int boardLength = 3;
        Coordinates expected = new Coordinates();
        expected.X = 1;
        expected.Y = 1;

        Coordinates result = MoveGenerator.translateIndexToCoordinates(boardLength, index);

        Assertions.assertEquals(expected.X, result.X);
        Assertions.assertEquals(expected.Y, result.Y);
    }

    @Test
    void givenIndexAndBoardLength3() {
        int index = 7;
        int boardLength = 3;
        Coordinates expected = new Coordinates();
        expected.X = 1;
        expected.Y = 2;

        Coordinates result = MoveGenerator.translateIndexToCoordinates(boardLength, index);

        Assertions.assertEquals(expected.X, result.X);
        Assertions.assertEquals(expected.Y, result.Y);
    }

    @Test
    void givenIndexAndBoardLength4() {
        int index = 4;
        int boardLength = 4;
        Coordinates expected = new Coordinates();
        expected.X = 0;
        expected.Y = 1;

        Coordinates result = MoveGenerator.translateIndexToCoordinates(boardLength, index);

        Assertions.assertEquals(expected.X, result.X);
        Assertions.assertEquals(expected.Y, result.Y);
    }

    @Test
    void givenIndexAndBoardLength5() {
        int index = 8;
        int boardLength = 4;
        Coordinates expected = new Coordinates();
        expected.X = 0;
        expected.Y = 2;

        Coordinates result = MoveGenerator.translateIndexToCoordinates(boardLength, index);

        Assertions.assertEquals(expected.X, result.X);
        Assertions.assertEquals(expected.Y, result.Y);
    }

    @Test
    void givenIndexAndBoardLength6() {
        int index = 10;
        int boardLength = 8;
        Coordinates expected = new Coordinates();
        expected.X = 2;
        expected.Y = 1;

        Coordinates result = MoveGenerator.translateIndexToCoordinates(boardLength, index);

        Assertions.assertEquals(expected.X, result.X);
        Assertions.assertEquals(expected.Y, result.Y);
    }

    @Test
    void givenIndexAndBoardLength7() {
        int index = 51;
        int boardLength = 8;
        Coordinates expected = new Coordinates();
        expected.X = 3;
        expected.Y = 6;

        Coordinates result = MoveGenerator.translateIndexToCoordinates(boardLength, index);

        Assertions.assertEquals(expected.X, result.X);
        Assertions.assertEquals(expected.Y, result.Y);
    }

    @Test
    void givenIndexAndBoardLength8() {
        int index = 34;
        int boardLength = 8;
        Coordinates expected = new Coordinates();
        expected.X = 2;
        expected.Y = 4;

        Coordinates result = MoveGenerator.translateIndexToCoordinates(boardLength, index);

        Assertions.assertEquals(expected.X, result.X);
        Assertions.assertEquals(expected.Y, result.Y);
    }
}
