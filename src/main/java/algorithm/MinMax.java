package algorithm;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import tak.Tak;

public final class MinMax {
    private static final Logger logger = LogManager.getLogger(MinMax.class);
    public static Tree constructTree(Tak.GameState state) {
        logger.info("Tree is in construction...");
        evaluate(state);
        return null;
    }
    public static int evaluate(Tak.GameState state) {
        logger.info("Boards are evaluated...");
        return 0;
    }
    public static Tak.PlaceAction alphaBetaPrune(Tree tree) {
        logger.info("Pruning tree and calculating best move...");
        return null;
    }
}
