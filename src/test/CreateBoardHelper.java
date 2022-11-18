import json.JSONWriter;
import tak.Tak;

import java.util.ArrayList;
import java.util.List;

public class CreateBoardHelper {
    private static final String PATH_TO_GAMES_FOLDER = "src/main/java/json/debug/";

    public static List<Tak.Pile> createBoard(int boardLength) {
        List<Tak.Pile> board = new ArrayList<>();
        for (int i = 0; i < boardLength * boardLength; i++) {
            board.add(Tak.Pile.newBuilder().build());
        }
        return board;
    }

    public static Tak.Pile getFlatStonePile(int height, boolean secondPlayerControlled) {
        Tak.Pile.Builder builder = getBuilder(height);
        builder.addPieces(getFlatStone(secondPlayerControlled));
        return builder.build();
    }

    public static Tak.Pile getStandingStonePile(int height, boolean secondPlayerControlled) {
        Tak.Pile.Builder builder = getBuilder(height);
        builder.addPieces(getStandingStone(secondPlayerControlled));
        return builder.build();
    }

    public static Tak.Pile getCapStonePile(int height, boolean secondPlayerControlled) {
        Tak.Pile.Builder builder = getBuilder(height);
        builder.addPieces(getCapStone(secondPlayerControlled));
        return builder.build();
    }

    public static Tak.Piece getFlatStone(boolean spo) {
        return  Tak.Piece.newBuilder().
                setType(Tak.PieceType.FLAT_STONE)
                .setSecondPlayerOwned(spo)
                .build();
    }

    private static Tak.Pile.Builder getBuilder(int height) {
        boolean min = true;
        Tak.Pile.Builder builder = Tak.Pile.newBuilder();
        for (int i = 0; i < height - 1; i++) {
            builder.addPieces(getFlatStone(min));
            min = !min;
        }
        return builder;
    }

    private static Tak.Piece getCapStone(boolean spo) {
        return  Tak.Piece.newBuilder()
                .setType(Tak.PieceType.CAPSTONE)
                .setSecondPlayerOwned(spo)
                .build();
    }

    private static Tak.Piece getStandingStone(boolean spo) {
        return  Tak.Piece.newBuilder()
                .setType(Tak.PieceType.STANDING_STONE)
                .setSecondPlayerOwned(spo)
                .build();
    }

    public static Tak.GameState createGameState(int boardLength, List<Tak.Pile> board) {
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

    public static void writeToJSON(Tak.GameState gameState, boolean beginningPlayer, String folderName, int stateNumber) {
        JSONWriter.writeGameStateToJSON(
                gameState,
                PATH_TO_GAMES_FOLDER + folderName + "/game_state_" + stateNumber +  ".json",
                beginningPlayer);
    }

}
