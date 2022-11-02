package algorithm;

import tak.Tak;

import java.util.ArrayList;

public class Tree {
    public Node root;

    public Tree(Tak.GameState state) {
        this.root = new Node();
        this.root.children = new ArrayList<>();
        this.root.currentState = state;
        this.root.min = false;
    }
}