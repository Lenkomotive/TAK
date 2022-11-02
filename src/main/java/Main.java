import algorithm.MinMax;
import client.Client;
import json.JsonWriter;
import netcode.Netcode;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import tak.Tak;
import utils.PieceColor;

import static java.lang.Thread.sleep;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    private static int SLEEP_MS = 1000;

    private static final String USER_TOKEN = "5d358d3a9ff2c036e7656d137d75723f8879f8c751350ddf62cb12ea02946a0d";
    private static final String GAME_TOKEN = "tak";
    private static int BOARD_LENGTH = 4;
    private static final int TIMEOUT = 10;

    private static Client client;

    private static boolean beginningPlayer;

    public static void main(String[] args) throws InterruptedException {
        BasicConfigurator.configure(); //
        client = new Client();
        while(true) {
            createMatch();
            waitForMatchToStart();
            checkOpponentInfo();
            checkAgreedTimeout();
            gameLoop();
        }
    }

    private static void createMatch() {
        Netcode.MatchResponse response = client.createMatchRequest(BOARD_LENGTH, USER_TOKEN, GAME_TOKEN, TIMEOUT);
        beginningPlayer = response.getBeginningPlayer();
        logger.info("Beginning player: " + beginningPlayer);

        MinMax.ourColor = beginningPlayer? PieceColor.WHITE : PieceColor.BLACK;
        logger.info("our color: " + MinMax.ourColor);

        String matchToken = response.getMatchToken();
        logger.info("Match token: " + matchToken);
        client.initMatchIDPacket(USER_TOKEN, matchToken);

        int boardLength = client.getGameState().getTakGameState().getBoardLength();
        logger.info("Playing on a " + boardLength+ "x" + boardLength + " Board");
    }

    private static void waitForMatchToStart() throws InterruptedException {
        while(client.getGameState().getGameStatus() == Netcode.GameStatus.MATCH_NOT_STARTED) {
            logger.info("Waiting for match to begin...");
            sleep(SLEEP_MS);
        }
        logger.info("Match starts!");
    }

    private static void checkOpponentInfo() {
        Netcode.OpponentInfoResponse opponentInfoResponse = client.getOpponentInfo();
        logger.info("We are playing against: "
                + opponentInfoResponse.getGroupPseudonym()
                + ", with a ELO value of: "
                + opponentInfoResponse.getElo().getGroupElo());
    }

    private static void checkAgreedTimeout() {
        logger.info("Agreed timeout: " + client.getTimeout());
    }

    private static void gameLoop() throws InterruptedException {
        while(matchIsRunning()) {
            if(itIsOpponentsTurn()) {
                logger.info("Opponents turn, let's wait...");
                sleep(SLEEP_MS);
                continue;
            }
            Tak.GameState state = client.getGameState().getTakGameState();
            MinMax.constructTree(state);
            Tak.GameTurn turn = MinMax.playValidPlaceMove(state);
            playTurn(turn);
        }
        logger.info("Match endend with status: " + client.getGameState().getGameStatus());
        logger.info("-----------------------------------------------------------------");
    }

    private static boolean matchIsRunning() {
        Netcode.GameStatus status = client.getGameState().getGameStatus();
        return (status == Netcode.GameStatus.YOUR_TURN) || (status == Netcode.GameStatus.OPPONENTS_TURN);
    }

    private static boolean itIsOpponentsTurn() {
        Netcode.GameStatus status = client.getGameState().getGameStatus();
        return status == Netcode.GameStatus.OPPONENTS_TURN;
    }

    private static void playTurn(Tak.GameTurn turn) {
        JsonWriter.writeGameStateToJSON(client.getGameState().getTakGameState(), beginningPlayer);
        Netcode.TurnResponse response = client.submitTurn(turn);
        switch (response.getTurnStatus()) {
            case OK -> logger.info("Turn status for x:" + turn.getX() + " y:" + turn.getY() + " is: " + response.getTurnStatus());
            case NOT_YOUR_TURN -> logger.error("It was not our Turn!");
            case INVALID_TURN -> logger.error("Invalid Turn played!");
            case MATCH_OVER -> logger.info("Match is over!");
        }
        JsonWriter.writeGameStateToJSON(client.getGameState().getTakGameState(), beginningPlayer);
    }
}