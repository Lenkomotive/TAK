import algorithm.MoveGenerator;
import algorithm.Tree;
import json.JSONWriter;
import org.junit.jupiter.api.Test;
import tak.Tak;
import utils.PieceColor;

import java.io.IOException;
import java.util.List;

public class MovingTest {

    private static final String PATH_TO_GAMES_FOLDER = "src/main/java/json/debug/";

    @Test
    void flatteningWall() throws IOException {
        String folderName = JSONWriter.createFolderForDebugGameStates(PATH_TO_GAMES_FOLDER);
        int boardLength = 3;
        MoveGenerator.ourColor = PieceColor.WHITE;
        List<Tak.Pile> board = CreateBoardHelper.createBoard(boardLength);
        board.set(4, CreateBoardHelper.getCapStonePile(1,false));
        board.set(5, CreateBoardHelper.getStandingStonePile(2,false));
        Tak.GameState originState = CreateBoardHelper.createGameState(boardLength, board);
        Tree tree = new Tree(originState);
        CreateBoardHelper.writeToJSON(originState, true, folderName, 0);
        boolean min = true;
        boolean beggingPlayer = true;

        //min
        tree.root.children.addAll(MoveGenerator.createAllMoveNodes(tree.root, originState, min));

        int counter = 0;
        for(var node :tree.root.children) {
            CreateBoardHelper.writeToJSON(originState, beggingPlayer, folderName, counter);
            counter++;
            CreateBoardHelper.writeToJSON(node.currentState, beggingPlayer, folderName, counter);
            counter++;
        }
    }

    @Test
    void flatteningWall1() throws IOException {
        String folderName = JSONWriter.createFolderForDebugGameStates(PATH_TO_GAMES_FOLDER);
        int boardLength = 6;
        MoveGenerator.ourColor = PieceColor.WHITE;
        List<Tak.Pile> board = CreateBoardHelper.createBoard(boardLength);
        board.set(15, CreateBoardHelper.getCapStonePile(5,false));
        board.set(33, CreateBoardHelper.getStandingStonePile(2,false));
        board.set(17, CreateBoardHelper.getFlatStonePile(7,true));
        board.set(14, CreateBoardHelper.getStandingStonePile(2,false));
        Tak.GameState originState = CreateBoardHelper.createGameState(boardLength, board);
        Tree tree = new Tree(originState);
        CreateBoardHelper.writeToJSON(originState, true, folderName, 0);
        boolean min = true;
        boolean beggingPlayer = true;

        //min
        tree.root.children.addAll(MoveGenerator.createAllMoveNodes(tree.root, originState, min));

        int counter = 0;
        for(var node :tree.root.children) {
            CreateBoardHelper.writeToJSON(originState, beggingPlayer, folderName, counter);
            counter++;
            CreateBoardHelper.writeToJSON(node.currentState, beggingPlayer, folderName, counter);
            counter++;
        }
    }
}
