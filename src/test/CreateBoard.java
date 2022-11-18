import json.JSONWriter;
import org.junit.jupiter.api.Test;
import tak.Tak;

import java.io.IOException;
import java.util.List;

public class CreateBoard {
    private static final String PATH_TO_GAMES_FOLDER = "src/main/java/json/debug/";

    @Test
    void createBoard() throws IOException {
        String folderName = JSONWriter.createFolderForDebugGameStates(PATH_TO_GAMES_FOLDER);
        int boardLength = 4;
        List<Tak.Pile> board = CreateBoardHelper.createBoard(boardLength);
        board.add(1, CreateBoardHelper.getFlatStonePile(4,true));
        board.add(2, CreateBoardHelper.getFlatStonePile(1,false));
        board.add(3, CreateBoardHelper.getStandingStonePile(4,true));
        board.add(4, CreateBoardHelper.getStandingStonePile(1,false));
        board.add(5, CreateBoardHelper.getCapStonePile(4,true));
        board.add(6, CreateBoardHelper.getCapStonePile(1,false));
        Tak.GameState state = CreateBoardHelper.createGameState(boardLength, board);
        writeToJSON(state, true, folderName, 0);
    }

    private static void writeToJSON(Tak.GameState gameState, boolean beginningPlayer, String folderName, int stateNumber) {
        JSONWriter.writeGameStateToJSON(
                gameState,
                PATH_TO_GAMES_FOLDER + folderName + "/debug_" + stateNumber +  ".json",
                beginningPlayer);
    }
}
