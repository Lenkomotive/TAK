package utils;

import algorithm.Node;

public class PruneNode {
    Node node;
    float val;
    public PruneNode(Node node, float val) {
        this.node = node;
        this.val = val;
    }

    public static PruneNode min(PruneNode a, PruneNode b) {
        if(Math.min(a.getVal(), b.getVal()) == a.getVal()) {
            return a;
        } else {
            return b;
        }
    }

    public static PruneNode max(PruneNode a, PruneNode b) {
        if(Math.max(a.getVal(), b.getVal()) == a.getVal()) {
            return a;
        } else {
            return b;
        }
    }

    public float getVal() {
        return val;
    }

    public Node getNode() {
        return node;
    }
}
