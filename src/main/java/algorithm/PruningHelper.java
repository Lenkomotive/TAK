package algorithm;

import utils.PruneNode;

import java.util.Map;

public class PruningHelper {
    public static PruneNode alphaBetaPrune(Node node, float alpha, float beta) {
        if(node.children.size() == 0) {
            return new PruneNode(node, node.val);
        }
        if(node.min) {
            PruneNode betaPruneNode = new PruneNode(node, beta);
            for(var child: node.children) {
                betaPruneNode = PruneNode.min(betaPruneNode, alphaBetaPrune(child, alpha, beta));
                if(betaPruneNode.getVal() <= alpha) {
                    return new PruneNode(child, alpha);
                }
            }
            return betaPruneNode;
        } else {
            PruneNode alphaPruneNode = new PruneNode(node, alpha);
            for(var child: node.children) {
                alphaPruneNode = PruneNode.max(alphaPruneNode, alphaBetaPrune(child, alpha, beta));
                if(beta <= alpha) {
                    return new PruneNode(child, beta);
                }
            }
            return alphaPruneNode;
        }
    }
}

