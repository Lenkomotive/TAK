package algorithm;

public class PruningHelper {
    public static int alphaBetaPrune(Node node, int alpha, int beta) {
        if(node.children.size() == 0) {
            return node.val;
        }
        if(node.min) {
            for(var child: node.children) {
                beta = Math.min(beta, alphaBetaPrune(child, alpha, beta));
                if(beta <= alpha) {
                    return alpha;
                }
            }
            return beta;
        } else {
            for(var child: node.children) {
                alpha = Math.max(alpha, alphaBetaPrune(child, alpha, beta));
                if(beta <= alpha) {
                    return beta;
                }
            }
            return alpha;
        }
    }
}

