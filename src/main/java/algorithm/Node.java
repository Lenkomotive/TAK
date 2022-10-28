package algorithm;

import game.Action;
import game.GameState;
import game.Stack;
import game.Stone;
import utils.Position;
import utils.StoneType;

import java.util.List;

public class Node {
    public boolean min;
    public int val;
    public Position playedPosition;
    public Stone playedStone;
    public Action action;
    public GameState currentState;
    public List<Node> children;
}
