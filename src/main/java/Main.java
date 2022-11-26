import algorithm.MoveGenerator;
import client.Client;
import json.JSONWriter;
import netcode.Netcode;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import tak.Tak;
import utils.PieceColor;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    private static final int SLEEP_MS = 1000;

    // JSON
    private static final String PATH_TO_GAMES_FOLDER = "src/main/java/json/games/";
    private static String currentFolderForGameStates;
    private static int turnCount;

    // Game parameter
    private static final int BOARD_LENGTH = 3;
    private static final int TIMEOUT = 20;
    private static final int NUM_GAMES = 501;
    public static int TREE_DEPTH = 3;
    private static String OPPONENT = "";

    private static Client client;
    private static boolean beginningPlayer;

    public static String matchToken = "";
    public static void main(String[] args) throws InterruptedException, IOException {
        BasicConfigurator.configure(); //log4j
        logger.setLevel(Level.ERROR);
        MoveGenerator.TREE_DEPTH = TREE_DEPTH;
        client = new Client();
        for (int i = 0; i < NUM_GAMES; i++) {
            turnCount = 0;
            currentFolderForGameStates = JSONWriter.createFolderForGameStates(PATH_TO_GAMES_FOLDER);
            createMatch(i+1);
            waitForMatchToStart();
            checkOpponentInfo();
            checkAgreedTimeout();
            gameLoop();
        }
    }

    private static void gameLoop() throws InterruptedException {
        boolean firstMove = true;
        while(matchIsRunning()) {
            if(itIsOpponentsTurn()) {
                logger.info("Opponents turn, let's wait...");
                sleep(SLEEP_MS);
                continue;
            }
            Tak.GameTurn turn = null;
            Tak.GameState state = client.getGameState().getTakGameState();
            writeToJSON(state);
            if(firstMove) {
                turn = MoveGenerator.playFirstMove(state);
                firstMove = false;
            } else {
//              turn =   MoveGenerator.playSmartMove(state);
                turn = MoveGenerator.playValidPlaceMove(state);
            }

        }
        Tak.GameState state = client.getGameState().getTakGameState();
        writeToJSON(state);
        logger.info("Match ended with status: " + client.getGameState().getGameStatus());
        logger.info("-----------------------------------------------------------------");
    }

    private static void createMatch(int numMatch) {

        Netcode.MatchResponse response;
        if(OPPONENT.equals("")) {
            response = client.createMatchRequest(BOARD_LENGTH, TIMEOUT);
        } else {
            response = client.createDirectMatchRequest(BOARD_LENGTH, TIMEOUT, OPPONENT);
        }
        beginningPlayer = response.getBeginningPlayer();
        logger.info("Beginning player: " + beginningPlayer);

        MoveGenerator.ourColor = beginningPlayer? PieceColor.WHITE : PieceColor.BLACK;
        MoveGenerator.opponentColor = beginningPlayer? PieceColor.BLACK: PieceColor.WHITE;
        logger.info("our color: " + MoveGenerator.ourColor);

        matchToken = response.getMatchToken();
        JSONWriter.matchToken = matchToken;
        logger.error("Match token: " + matchToken);
        client.initMatchIDPacket(matchToken);

        int boardLength = client.getGameState().getTakGameState().getBoardLength();

        if(boardLength > 6) {
            TREE_DEPTH = 3;
            MoveGenerator.TREE_DEPTH = TREE_DEPTH;
        }
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
                + opponentInfoResponse.getUserPseudonym()
                + " from Group: "
                + opponentInfoResponse.getGroupPseudonym()
                + ", ELO: "
                + opponentInfoResponse.getElo().getGroupElo());
    }

    private static void checkAgreedTimeout() {
        logger.info("Agreed timeout: " + client.getTimeout());
    }

    private static boolean matchIsRunning() {
        Netcode.GameStatus status = client.getGameState().getGameStatus();
        return (status == Netcode.GameStatus.YOUR_TURN) || (status == Netcode.GameStatus.OPPONENTS_TURN);
    }

    private static boolean itIsOpponentsTurn() {
        Netcode.GameStatus status = client.getGameState().getGameStatus();
        return status == Netcode.GameStatus.OPPONENTS_TURN;
    }

    private static boolean itIsOurTurn() {
        Netcode.GameStatus status = client.getGameState().getGameStatus();
        return status == Netcode.GameStatus.YOUR_TURN;
    }

    private static void playTurn(Tak.GameTurn turn) {
        Netcode.TurnResponse response = client.submitTurn(turn);
        writeToJSON(response.getTakGameState());

        switch (response.getTurnStatus()) {
            case OK -> logger.info("Turn status for x:" + turn.getX() + " y:" + turn.getY() + " is: " + response.getTurnStatus());
            case NOT_YOUR_TURN -> logger.error("It was not our Turn!");
            case INVALID_TURN -> logger.error("Invalid Turn played! x: " + turn.getX() + " y: " + turn.getY());
            case MATCH_OVER -> logger.info("Match is over!");
        }
        assert (response.getTurnStatus() == Netcode.TurnStatus.INVALID_TURN);
    }

    private static void writeToJSON(Tak.GameState gameState) {
        JSONWriter.writeGameStateToJSON(
                gameState,
                PATH_TO_GAMES_FOLDER + currentFolderForGameStates + "/game_state_" + turnCount +  ".json",
                beginningPlayer);
        turnCount++;
    }
}