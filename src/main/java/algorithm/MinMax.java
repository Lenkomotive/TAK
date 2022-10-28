package algorithm;

import game.Action;
import game.GameState;
import game.Stack;

import java.util.List;

public final class MinMax {

    public static Tree constructTree(GameState state) {
        // TODO 1: find all possible moves, make node for every move played (MAX)
        // TODO 2: find all possible moves for opponent and make node (MIN)
        // TODO 3: find again all moves for us based on changed board and evaluate every board
        return null;
    }

    // evaluate the utility of the board
    public static int evaluate(List<Stack> board) {
        return 0;
    }

    // analyze tree after every board state was evaluated
    public static Action alphaBetaPrune(Tree tree) {
        return null;
    }
}
