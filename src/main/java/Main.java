import client.Client;
import netcode.Netcode;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static java.lang.Thread.sleep;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    private static final String USER_TOKEN = "5d358d3a9ff2c036e7656d137d75723f8879f8c751350ddf62cb12ea02946a0d";
    private static final String GAME_TOKEN = "tak";
    private static int BOARD_LENGTH = 3;
    private static final int TIMEOUT = 10;

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
        Netcode.MatchIDPacket matchIDPacket = client.createMatchIdPacket(USER_TOKEN, matchToken);
        while(client.getGameStatus(matchIDPacket) == Netcode.GameStatus.MATCH_NOT_STARTED) {
            logger.info("waiting for match to begin...");
            sleep(1000);
        }
        logger.info("Match status: " + client.getGameStatus(matchIDPacket));

    }
    private static void checkOpponentInfo() {
        Netcode.MatchIDPacket matchIDPacket = client.createMatchIdPacket(USER_TOKEN, matchToken);
        Netcode.OpponentInfoResponse opponentInfoResponse =  client.getOpponentInfo(matchIDPacket);
        logger.info("We are playing against: "
                + opponentInfoResponse.getGroupPseudonym()
                + ", with ELO: "
                + opponentInfoResponse.getElo().getGroupElo());
    }


    private static void checkAgreedTimeout() {
        Netcode.MatchIDPacket matchIDPacket = client.createMatchIdPacket(USER_TOKEN, matchToken);
        logger.info("timeout: " + client.getAgreedTimeout(matchIDPacket));
    }
}