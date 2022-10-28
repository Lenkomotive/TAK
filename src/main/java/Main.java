import algorithm.MinMax;
import algorithm.Tree;
import game.Action;
import game.GameState;

public class Main {
    public static void main(String[] args) {
        GameState state = GameState.getDummyGameState3x3();
        Tree tree = MinMax.constructTree(state);
        Action action = MinMax.alphaBetaPrune(tree);
        System.out.println("baki is gay");
    }
}