package algorithm;

import tak.Tak;

import java.util.List;

public class Node {
    public boolean min;
    public int val;
    public int positionX;
    public int PositionY;
    public Tak.PlaceAction placeAction;
    public Tak.MoveAction moveAction;
    public Tak.GameState currentState;
    public List<Node> children;
}
