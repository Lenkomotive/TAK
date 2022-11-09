import algorithm.MinMax;
import algorithm.Tree;
import json.JSONWriter;
import org.junit.jupiter.api.Test;
import tak.Tak;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateMovingGameTurnNodesTest {

    private static String PATH_TO_GAMES_FOLDER = "src/main/java/json/debug/";

    @Test
    void test() throws IOException {
        int boardLength = 4;
        boolean beggingPlayer = true;
        List<Tak.Pile> board = createBoard(boardLength);
        board.set(4, getFlatStonePile());
        Tak.GameState originState = createGameState(boardLength, board);
        String folderName = JSONWriter.createFolderForDebugGameStates(PATH_TO_GAMES_FOLDER);
        boolean min = true;
        Tree tree = new Tree(originState);
        //min
        tree.root.children.addAll(MinMax.createAllMoveNodes(tree.root, originState, min));

        int counter = 0;
        for(var node :tree.root.children) {
            writeToJSON(originState, beggingPlayer, folderName, counter);
            counter++;
            writeToJSON(node.currentState, beggingPlayer, folderName, counter);
            counter++;
        }

    }

    private static void writeToJSON(Tak.GameState gameState, boolean beginningPlayer, String folderName, int state) {
        JSONWriter.writeGameStateToJSON(
                gameState,
                PATH_TO_GAMES_FOLDER + folderName + "/debug_" + state +  ".json",
                beginningPlayer);
    }

    private Tak.Pile getFlatStonePile() {
        return Tak.Pile.newBuilder()
                .addPieces(getFlatStone(true))
                .addPieces(getFlatStone(false))
                .addPieces(getFlatStone(false))
                .addPieces(getFlatStone(true))
                .addPieces(getFlatStone(true))
                .addPieces(getFlatStone(true))
                .addPieces(getFlatStone(false))
                .addPieces(getFlatStone(true))
                .addPieces(getFlatStone(false))
                .addPieces(getFlatStone(true))
                .addPieces(getFlatStone(false))
                .build();
    }

    private Tak.Pile getStandingStonePile() {
        return Tak.Pile.newBuilder()
                .addPieces(getFlatStone(true))
                .addPieces(getFlatStone(false))
                .addPieces(getFlatStone(false))
                .addPieces(getFlatStone(true))
                .addPieces(getFlatStone(true))
                .addPieces(getStandingStone())
                .build();
    }

    private Tak.Pile getCapStonePile() {
        return Tak.Pile.newBuilder()
                .addPieces(getCapStone())
                .build();
    }


    private List<Tak.Pile> createBoard(int boardLength) {
        List<Tak.Pile> board = new ArrayList<>();
        for (int i = 0; i < boardLength * boardLength; i++) {
            board.add(Tak.Pile.newBuilder().build());
        }
        return board;
    }

    private Tak.GameState createGameState(int boardLength, List<Tak.Pile> board) {
        List<Integer> remainingStoneList = new ArrayList<>();
        remainingStoneList.add(15);
        remainingStoneList.add(15);
        List<Integer> remainingCapStoneList = new ArrayList<>();
        remainingCapStoneList.add(2);
        remainingCapStoneList.add(2);
        return Tak.GameState.newBuilder()
                .setBoardLength(boardLength)
                .addAllRemainingStones(remainingStoneList)
                .addAllRemainingCapstones(remainingCapStoneList)
                .addAllBoard(board)
                .build();
    }

    private Tak.Piece getFlatStone(boolean spo) {
        return  Tak.Piece.newBuilder().
                setType(Tak.PieceType.FLAT_STONE)
                .setSecondPlayerOwned(spo)
                .build();
    }

    private Tak.Piece getCapStone() {
        return  Tak.Piece.newBuilder().setType(Tak.PieceType.CAPSTONE).build();
    }

    private Tak.Piece getStandingStone() {
        return  Tak.Piece.newBuilder().setType(Tak.PieceType.STANDING_STONE).build();
    }
}