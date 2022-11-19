package algorithm;

import com.google.common.collect.Lists;
import org.apache.http.io.SessionOutputBuffer;
import tak.Tak;
import utils.PieceColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Evaluator {

    public float getEvalCaptured(Tak.GameState state, PieceColor ourColor) {
        List<Tak.Pile> boardList = state.getBoardList();
        Map<String, Float> pieceCount = new HashMap<>(Map.of("White", 0.0f, "Black", 0.0f));
        for (var pile : boardList) {
            if(pile.getPiecesList().size() == 0) continue;
            Tak.Piece topStone = pile.getPiecesList().get((pile.getPiecesList().size() - 1));
            if (!topStone.getSecondPlayerOwned()) {
                pieceCount.put("White", pieceCount.get("White") + 1);
            } else {
                pieceCount.put("Black", pieceCount.get("Black") + 1);
            }
        }

        float diff = pieceCount.get("White") - pieceCount.get("Black");

        if (ourColor == PieceColor.BLACK) {
            return pieceCount.get("Black") - pieceCount.get("White");
        } else{
            return pieceCount.get("White") - pieceCount.get("Black");
        }
    }

    public float getEvalComposition(Tak.GameState state , PieceColor ourColor) {
        List<Tak.Pile> boardList = state.getBoardList();

        int boardLength = state.getBoardLength();

        List<List<Tak.Pile>> partition = new ArrayList<>();
        for (int row = 0, i = 0; row < boardLength; row++) {
            partition.add(new ArrayList<Tak.Pile>());
            for (int column = 0; column < boardLength ; column++, i++) {
                partition.get(row).add(boardList.get(i));
            }
        }
        Map<String, List<Float>> snakes = new HashMap<>(Map.of("White", new ArrayList<>(),"Black", new ArrayList<>()));

        for (int row = 0; row < partition.size(); row++) {
            for (int column = 0; column < partition.get(0).size(); column++) {
                List<Tak.Piece> pile = partition.get(row).get(column).getPiecesList();
                if (pile.size() == 0) continue;
                if (pile.get(pile.size() - 1).getSecondPlayerOwned()) {
                    float snake = depthFirstSearch(partition, row, column, PieceColor.BLACK);
                     snakes.get("Black").add(snake);
                }
                if(!pile.get(pile.size() - 1).getSecondPlayerOwned()) {
                    float snake = depthFirstSearch(partition, row, column, PieceColor.WHITE);
                    snakes.get("White").add(snake);
                }
            }
        }

        float whiteSnakeScore = 0.0f;
        float blackSnakeScore = 0.0f;

        for (var snakeLength : snakes.get("Black")) {
            blackSnakeScore += Math.pow(32.0f, snakeLength/boardLength);
        }

        for (var snakeLength : snakes.get("White")) {
            whiteSnakeScore += Math.pow(32.0f, snakeLength/boardLength);
        }

//        snakes.forEach((key, value) -> {
//            System.out.print(key + ":");
//            value.forEach((val) -> {
//                System.out.print(" " + val);
//            });
//            System.out.println(".");
//        });

        if (ourColor == PieceColor.BLACK) {
            return blackSnakeScore - whiteSnakeScore;
        } else{
            return whiteSnakeScore - blackSnakeScore;
        }
    }

    private float depthFirstSearch(List<List<Tak.Pile>> partition, int row, int column, PieceColor pieceColor) {
        if(row < 0 || column < 0 || row >= partition.size() || column >= partition.get(row).size()) {
            return 0.0f;
        }



        if(partition.get(row).get(column).getPiecesList().size() == 0) {
            return 0.0f;
        }

        List<Tak.Piece> pile = partition.get(row).get(column).getPiecesList();
        PieceColor topStone = pile.get(pile.size() - 1).getSecondPlayerOwned() ? PieceColor.BLACK : PieceColor.WHITE;

        if(topStone != pieceColor) {
            return 0.0f;
        }

        partition.get(row).set(column, Tak.Pile.newBuilder().build());

        float connected = 1;

        connected += depthFirstSearch(partition, row + 1, column, pieceColor);
        connected += depthFirstSearch(partition, row - 1, column, pieceColor);
        connected += depthFirstSearch(partition, row , column + 1, pieceColor);
        connected += depthFirstSearch(partition, row, column - 1, pieceColor);
        return connected;
    }
}
