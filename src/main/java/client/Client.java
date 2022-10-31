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

    public Netcode.MatchRequest createMatchRequest(int boardLength, String userToken, String gameToken, int timeout) {
        Tak.GameParameter gameParameter = createGameParameter(boardLength);
        Netcode.MatchRequest.Builder matchRequestBuilder = Netcode.MatchRequest.newBuilder();
        return matchRequestBuilder
                .setUserToken(userToken)
                .setGameToken(gameToken)
                .setTimeoutSuggestionSeconds(timeout)
                .setTakGameParameters(gameParameter)
                .build();
    }

    public Netcode.MatchResponse requestNewMatch(Netcode.MatchRequest request) {
        return stub.newMatch(request);
    }

    public Netcode.MatchIDPacket createMatchIdPacket(String userToken, String matchToken){
        return Netcode.MatchIDPacket.newBuilder()
                .setUserToken(userToken)
                .setMatchToken(matchToken)
                .build();
    }

    public Netcode.OpponentInfoResponse getOpponentInfo(Netcode.MatchIDPacket matchIDPacket) {
        return stub.getOpponentInfo(matchIDPacket);
    }

    public Netcode.GameStatus getGameStatus(Netcode.MatchIDPacket matchIDPacket) {
        return stub.getGameState(matchIDPacket).getGameStatus();
    }

    public int getAgreedTimeout(Netcode.MatchIDPacket matchIDPacket) {
        return stub.getTimeout(matchIDPacket).getTimeoutSeconds();
    }

    private Tak.GameParameter createGameParameter(int boardLength) {
        Tak.GameParameter.Builder gameParameterBuilder = Tak.GameParameter.newBuilder();
        return gameParameterBuilder.setBoardLength(boardLength).build();
    }


}
