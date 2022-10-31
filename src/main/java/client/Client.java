package client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import netcode.GameComGrpc;
import netcode.Netcode;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import tak.Tak;

public class Client {
    private static final Logger logger = LogManager.getLogger(Client.class);

    private final String HOST = "gameserver.ist.tugraz.at";
    private final int PORT = 80;

    private final ManagedChannel channel;
    private final GameComGrpc.GameComBlockingStub stub;

    public Client() {
        channel = ManagedChannelBuilder.forAddress(HOST, PORT)
                .usePlaintext()
                .build();
        stub = GameComGrpc.newBlockingStub(channel);
    }

    public Netcode.MatchResponse requestNewMatch(Netcode.MatchRequest request) {
        logger.info("New Match requested");
        return stub.newMatch(request);
    }

    public Netcode.TurnResponse submitTurn(Netcode.TurnRequest turnRequest) {
        logger.info("Turn submitted");
        return stub.submitTurn(turnRequest);
    }

    public Netcode.GameStateResponse getGameState(Netcode.MatchIDPacket matchIDPacket) {
        return stub.getGameState(matchIDPacket);
    }

    public int getTimeout(Netcode.MatchIDPacket matchIDPacket) {
        return stub.getTimeout(matchIDPacket).getTimeoutSeconds();
    }

    public Netcode.OpponentInfoResponse getOpponentInfo(Netcode.MatchIDPacket matchIDPacket) {
        return stub.getOpponentInfo(matchIDPacket);
    }

    public Netcode.EloValues getEloValues(Netcode.IDPacket idPacket) {
        return stub.getElo(idPacket);
    }

    public Netcode.MatchRequest createMatchRequest(int boardLength, String userToken, String gameToken, int timeout) {
        Tak.GameParameter gameParameter = Tak.GameParameter.newBuilder().setBoardLength(boardLength).build();
        Netcode.MatchRequest.Builder matchRequestBuilder = Netcode.MatchRequest.newBuilder();
        return matchRequestBuilder
                .setUserToken(userToken)
                .setGameToken(gameToken)
                .setTimeoutSuggestionSeconds(timeout)
                .setTakGameParameters(gameParameter)
                .build();
    }

    public Netcode.TurnRequest createTurnRequest(Netcode.MatchIDPacket matchIDPacket, Tak.GameTurn gameTurn) {
        return  Netcode.TurnRequest.newBuilder()
                .setMatchId(matchIDPacket)
                .setTakGameTurn(gameTurn)
                .build();
    }

    public Netcode.MatchIDPacket createMatchIdPacket(String userToken, String matchToken){
        return Netcode.MatchIDPacket.newBuilder()
                .setUserToken(userToken)
                .setMatchToken(matchToken)
                .build();
    }

    public Netcode.IDPacket createIDPacket(String userToken) {
        return Netcode.IDPacket.newBuilder()
                .setUserToken(userToken)
                .build();
    }
}
