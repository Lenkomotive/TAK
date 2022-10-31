import algorithm.MinMax;
import algorithm.Tree;
import client.Client;
import netcode.Netcode;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import tak.Tak;

import static java.lang.Thread.sleep;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    private static final String USER_TOKEN = "5d358d3a9ff2c036e7656d137d75723f8879f8c751350ddf62cb12ea02946a0d";
    private static final String GAME_TOKEN = "tak";
    private static int BOARD_LENGTH = 3;
    private static final int TIMEOUT = 69;

    private static Client client;

    private static String matchToken;
    private static boolean beginningPlayer;
    public static void main(String[] args) throws InterruptedException {
        BasicConfigurator.configure(); //log4j
        client = new Client();
        createMatch();
        waitForMatchToStart();
        checkOpponentInfo();
        checkAgreedTimeout();
        gameLoop();
    }
    private static void createMatch() {
        Netcode.MatchRequest request = client.createMatchRequest(BOARD_LENGTH, USER_TOKEN, GAME_TOKEN, TIMEOUT);
        Netcode.MatchResponse response = client.requestNewMatch(request);
        matchToken = response.getMatchToken();
        beginningPlayer = response.getBeginningPlayer();
        logger.info("Match token: " + matchToken);
        logger.info("Beginning player: " + beginningPlayer);
    }
    private static void waitForMatchToStart() throws InterruptedException {
        while(queryGameState().getGameStatus() == Netcode.GameStatus.MATCH_NOT_STARTED) {
            logger.info("Waiting for match to begin...");
            sleep(1000);
        }
        logger.info("Match starts!");
    }
    private static void checkOpponentInfo() {
        Netcode.MatchIDPacket matchIDPacket = client.createMatchIdPacket(USER_TOKEN, matchToken);
        Netcode.OpponentInfoResponse opponentInfoResponse = client.getOpponentInfo(matchIDPacket);
        logger.info("We are playing against: "
                + opponentInfoResponse.getGroupPseudonym()
                + ", with a ELO value of: "
                + opponentInfoResponse.getElo().getGroupElo());
    }
    private static void checkAgreedTimeout() {
        Netcode.MatchIDPacket matchIDPacket = client.createMatchIdPacket(USER_TOKEN, matchToken);
        logger.info("Agreed timeout: " + client.getTimeout(matchIDPacket));
    }

    private static void gameLoop() throws InterruptedException {
        while(matchIsRunning()) {
            if(itIsOpponentsTurn()) {
                logger.info("Opponents turn, let's wait...");
                sleep(1000);
                continue;
            }
            logger.info("Our turn!");
            Tak.GameState state = queryGameState().getTakGameState();
            logger.info("Board length: " + state.getBoardLength());
            logger.info("Capstones: " + state.getRemainingCapstonesList());
            logger.info("Remaining stones: " + state.getRemainingStonesList());
            Tree tree = MinMax.constructTree(state);
            Tak.PlaceAction action = MinMax.alphaBetaPrune(tree);
            //TODO calculate our turn!
            logger.info("\n");
        }
    }
    private static boolean matchIsRunning() {
        Netcode.GameStatus status = queryGameState().getGameStatus();
        return (status == Netcode.GameStatus.YOUR_TURN) || (status == Netcode.GameStatus.OPPONENTS_TURN);
    }
    private static boolean itIsOpponentsTurn() {
        Netcode.GameStatus status = queryGameState().getGameStatus();
        return status == Netcode.GameStatus.OPPONENTS_TURN;
    }
    private static Netcode.GameStateResponse queryGameState() {
        Netcode.MatchIDPacket matchIDPacket = client.createMatchIdPacket(USER_TOKEN, matchToken);
        return client.getGameState(matchIDPacket);
    }
}