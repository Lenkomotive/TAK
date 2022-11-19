import algorithm.Evaluator;
import json.JSONWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tak.Tak;
import utils.PieceColor;

import java.io.IOException;
import java.util.List;

public class CreateBoard {

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
}
