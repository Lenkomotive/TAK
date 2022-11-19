import algorithm.MoveGenerator;
import algorithm.Tree;
import json.JSONWriter;
import org.junit.jupiter.api.Test;
import tak.Tak;
import utils.PieceColor;

import java.io.IOException;
import java.util.List;

public class CreateTree {

    private static final String PATH_TO_GAMES_FOLDER = "src/main/java/json/debug/";

    @Test
    void createTree() throws IOException {
        String folderName = JSONWriter.createFolderForDebugGameStates(PATH_TO_GAMES_FOLDER);
        int boardLength = 6;
        MoveGenerator.ourColor = PieceColor.WHITE;
        List<Tak.Pile> board = CreateBoardHelper.createBoard(boardLength);
        board.set(4, CreateBoardHelper.getFlatStonePile(4,false));
        board.set(16, CreateBoardHelper.getFlatStonePile(8,false));
        board.set(24, CreateBoardHelper.getCapStonePile(5,false));
        board.set(13, CreateBoardHelper.getStandingStonePile(7,false));
        Tak.GameState originState = CreateBoardHelper.createGameState(boardLength, board);
        Tree tree = new Tree(originState);
        CreateBoardHelper.writeToJSON(originState, true, folderName, 0);
        boolean min = true;
        boolean beggingPlayer = true;

        //min
        tree.root.children.addAll(MoveGenerator.createAllPlaceNodes(tree.root, originState, min));
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