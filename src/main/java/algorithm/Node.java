package algorithm;

import tak.Tak;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public boolean min;
    public int val;
    public Node parent;
    public Tak.GameTurn gameTurn;
    public Tak.GameState currentState;
    public List<Node> children;

    public Node(){};
    public Node(Node parent, boolean min, Tak.GameTurn gameTurn, Tak.GameState gameState) {
        this.min = min;
        this.gameTurn = gameTurn;
        this.currentState = gameState;
        this.children = new ArrayList<>();
    }
}
