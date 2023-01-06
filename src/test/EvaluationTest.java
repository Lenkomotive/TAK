import algorithm.Evaluator;
import json.JSONWriter;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tak.Tak;
import utils.PieceColor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EvaluationTest {
    private static final Logger logger = LogManager.getLogger(EvaluationTest.class);

    private static final String PATH_TO_GAMES_FOLDER = "src/main/java/json/debug/";

    @Test
    void createBoard() throws IOException {
        String folderName = JSONWriter.createFolderForDebugGameStates(PATH_TO_GAMES_FOLDER);
        int boardLength = 6;
        List<Tak.Pile> board = CreateBoardHelper.createBoard(boardLength);
        board.set(0, CreateBoardHelper.getFlatStonePile(4,true));
        board.set(1, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(7, CreateBoardHelper.getStandingStonePile(4,true));
        board.set(18, CreateBoardHelper.getStandingStonePile(1,true));
        board.set(19, CreateBoardHelper.getStandingStonePile(3,true));
        board.set(20, CreateBoardHelper.getStandingStonePile(5,true));
        board.set(25, CreateBoardHelper.getStandingStonePile(1,true));
        board.set(16, CreateBoardHelper.getStandingStonePile(2,true));
        board.set(22, CreateBoardHelper.getStandingStonePile(1,true));
        board.set(28, CreateBoardHelper.getStandingStonePile(1,true));
        board.set(29, CreateBoardHelper.getStandingStonePile(1,true));
        board.set(5, CreateBoardHelper.getStandingStonePile(1,true));

        Tak.GameState state = CreateBoardHelper.createGameState(boardLength, board);
        Evaluator evaluator = new Evaluator();

        Assertions.assertEquals(27.597388, evaluator.getEvalComposition(state, PieceColor.BLACK), 0.002);

    }

    @Test
    void getEvalCapturedTestWhite() {
        int boardLength = 6;
        List<Tak.Pile> board = CreateBoardHelper.createBoard(boardLength);
        board.set(4, CreateBoardHelper.getFlatStonePile(4,false));
        board.set(16, CreateBoardHelper.getFlatStonePile(8,false));
        board.set(24, CreateBoardHelper.getCapStonePile(5,false));
        board.set(13, CreateBoardHelper.getStandingStonePile(7,false));
        Tak.GameState originState = CreateBoardHelper.createGameState(boardLength, board);

        Evaluator evaluator = new Evaluator();

        Assertions.assertEquals(4, evaluator.getEvalCaptured(originState, PieceColor.WHITE));
    }
    @Test
    void getEvalCapturedTestBlack() {
        int boardLength = 6;
        List<Tak.Pile> board = CreateBoardHelper.createBoard(boardLength);
        board.set(4, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(16, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(24, CreateBoardHelper.getCapStonePile(1,true));
        board.set(13, CreateBoardHelper.getStandingStonePile(1,true));
        Tak.GameState originState = CreateBoardHelper.createGameState(boardLength, board);

        Evaluator evaluator = new Evaluator();

        Assertions.assertEquals(4, evaluator.getEvalCaptured(originState, PieceColor.BLACK));
    }

    @Test
    void testWinDetectionCornersTopToBottom() {
        BasicConfigurator.configure();
        Evaluator evaluator = new Evaluator();
        int boardLength = 4;
        List<Tak.Pile> board = CreateBoardHelper.createBoard(boardLength);
        board.set(0, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(4, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(8, CreateBoardHelper.getCapStonePile(1,true));
        board.set(12, CreateBoardHelper.getStandingStonePile(1,true));
        Tak.GameState originState = CreateBoardHelper.createGameState(boardLength, board);

        evaluator.getEvalComposition(originState, PieceColor.BLACK);

        Assertions.assertTrue(evaluator.blackWinningMoveDetected);
    }
    @Test
    void testWinDetectionCornersTopToBottomMiddle() {
        BasicConfigurator.configure();
        Evaluator evaluator = new Evaluator();
        int boardLength = 4;
        List<Tak.Pile> board = CreateBoardHelper.createBoard(boardLength);
        board.set(1, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(5, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(9, CreateBoardHelper.getCapStonePile(1,true));
        board.set(13, CreateBoardHelper.getStandingStonePile(1,true));
        Tak.GameState originState = CreateBoardHelper.createGameState(boardLength, board);

        evaluator.getEvalComposition(originState, PieceColor.BLACK);

        Assertions.assertTrue(evaluator.blackWinningMoveDetected);
    }

    @Test
    void testWinDetectionCornersLeftToRight() {
        BasicConfigurator.configure();
        Evaluator evaluator = new Evaluator();
        int boardLength = 4;
        List<Tak.Pile> board = CreateBoardHelper.createBoard(boardLength);
        board.set(0, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(1, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(2, CreateBoardHelper.getCapStonePile(1,true));
        board.set(3, CreateBoardHelper.getStandingStonePile(1,true));
        Tak.GameState originState = CreateBoardHelper.createGameState(boardLength, board);

        evaluator.getEvalComposition(originState, PieceColor.BLACK);

        Assertions.assertTrue(evaluator.blackWinningMoveDetected);
    }

    @Test
    void testWinDetectionCornersLeftToRightMiddle() {
        BasicConfigurator.configure();
        Evaluator evaluator = new Evaluator();
        int boardLength = 4;
        List<Tak.Pile> board = CreateBoardHelper.createBoard(boardLength);
        board.set(4, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(5, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(6, CreateBoardHelper.getCapStonePile(1,true));
        board.set(7, CreateBoardHelper.getStandingStonePile(1,true));
        Tak.GameState originState = CreateBoardHelper.createGameState(boardLength, board);

        evaluator.getEvalComposition(originState, PieceColor.BLACK);

        Assertions.assertTrue(evaluator.blackWinningMoveDetected);
    }

    @Test
    void testWinDetectionCornersStairCase() {
        BasicConfigurator.configure();
        Evaluator evaluator = new Evaluator();
        int boardLength = 4;
        List<Tak.Pile> board = CreateBoardHelper.createBoard(boardLength);
        board.set(0, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(1, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(5, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(6, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(10, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(11, CreateBoardHelper.getFlatStonePile(1,true));
        Tak.GameState originState = CreateBoardHelper.createGameState(boardLength, board);

        evaluator.getEvalComposition(originState, PieceColor.BLACK);

        Assertions.assertTrue(evaluator.blackWinningMoveDetected);
    }

    @Test
    void testWinDetectionCornersStairCaseRightToLeft() {
        BasicConfigurator.configure();
        Evaluator evaluator = new Evaluator();
        int boardLength = 4;
        List<Tak.Pile> board = CreateBoardHelper.createBoard(boardLength);
        board.set(3, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(7, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(6, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(10, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(9, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(8, CreateBoardHelper.getFlatStonePile(1,true));
        Tak.GameState originState = CreateBoardHelper.createGameState(boardLength, board);

        evaluator.getEvalComposition(originState, PieceColor.BLACK);

        Assertions.assertTrue(evaluator.blackWinningMoveDetected);
    }

    @Test
    void testWinDetectionCornersLShape() {
        BasicConfigurator.configure();
        Evaluator evaluator = new Evaluator();
        int boardLength = 4;
        List<Tak.Pile> board = CreateBoardHelper.createBoard(boardLength);
        board.set(8, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(9, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(10, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(6, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(2, CreateBoardHelper.getFlatStonePile(1,true));
        Tak.GameState originState = CreateBoardHelper.createGameState(boardLength, board);

        evaluator.getEvalComposition(originState, PieceColor.BLACK);

        Assertions.assertFalse(evaluator.blackWinningMoveDetected);
    }

    @Test
    void testWinDetectionCornersStairCase8x8() {
        BasicConfigurator.configure();
        Evaluator evaluator = new Evaluator();
        int boardLength = 8;
        List<Tak.Pile> board = CreateBoardHelper.createBoard(boardLength);
        board.set(6, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(7, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(11, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(12, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(13, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(14, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(19, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(20, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(27, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(34, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(35, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(42, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(48, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(49, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(50, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(56, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(36, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(43, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(5, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(33, CreateBoardHelper.getFlatStonePile(1,true));
        Tak.GameState originState = CreateBoardHelper.createGameState(boardLength, board);

        evaluator.getEvalComposition(originState, PieceColor.BLACK);

        Assertions.assertTrue(evaluator.blackWinningMoveDetected);
    }

    @Test
    void testWinDetectionCornersEdgeCase() {
        BasicConfigurator.configure();
        Evaluator evaluator = new Evaluator();
        int boardLength = 8;
        List<Tak.Pile> board = CreateBoardHelper.createBoard(boardLength);
        board.set(6, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(7, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(9, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(10, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(11, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(12, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(13, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(14, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(17, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(25, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(26, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(27, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(28, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(36, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(41, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(42, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(43, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(44, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(49, CreateBoardHelper.getFlatStonePile(1,true));
        board.set(57, CreateBoardHelper.getCapStonePile(1,true));
        Tak.GameState originState = CreateBoardHelper.createGameState(boardLength, board);

        evaluator.getEvalComposition(originState, PieceColor.BLACK);

        Assertions.assertTrue(evaluator.blackWinningMoveDetected);
    }

}
