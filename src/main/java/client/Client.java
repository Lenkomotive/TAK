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

    private Netcode.MatchIDPacket matchIDPacket;

    public Client() {
        channel = ManagedChannelBuilder.forAddress(HOST, PORT)
                .usePlaintext()
                .build();
        stub = GameComGrpc.newBlockingStub(channel);
    }

    public void initMatchIDPacket(String userToken, String matchToken) {
        matchIDPacket = Netcode.MatchIDPacket.newBuilder()
                .setUserToken(userToken)
                .setMatchToken(matchToken)
                .build();
    }

    public Netcode.GameStateResponse getGameState() {
        return stub.getGameState(matchIDPacket);
    }

    public int getTimeout() {
        return stub.getTimeout(matchIDPacket).getTimeoutSeconds();
    }

    public Netcode.OpponentInfoResponse getOpponentInfo() {
        return stub.getOpponentInfo(matchIDPacket);
    }

    public Netcode.MatchResponse createMatchRequest(int boardLength, String userToken, String gameToken, int timeout) {
        Tak.GameParameter gameParameter = Tak.GameParameter.newBuilder()
                .setBoardLength(boardLength)
                .build();
        Netcode.MatchRequest request  = Netcode.MatchRequest.newBuilder()
                .setUserToken(userToken)
                .setGameToken(gameToken)
                .setTimeoutSuggestionSeconds(timeout)
                .setTakGameParameters(gameParameter)
                .build();
        return stub.newMatch(request);
    }

    public Netcode.TurnResponse submitTurn(Tak.GameTurn gameTurn) {
        Netcode.TurnRequest request = Netcode.TurnRequest.newBuilder()
                                        .setMatchId(matchIDPacket)
                                        .setTakGameTurn(gameTurn)
                                        .build();
        return stub.submitTurn(request);
    }

    public void setGroupName() {
        Netcode.AuthPacket authPacket = Netcode.AuthPacket.newBuilder()
                .setMatrNumber("11902857")
                .setSecret("Algo123+")
                .build();

        Netcode.SetPseudonymRequest request =  Netcode.SetPseudonymRequest.newBuilder()
                .setAuth(authPacket)
                .setPseudonym("StickFish")
                .build();
        Netcode.SetPseudonymResponse response =  stub.setGroupPseudonym(request);
        logger.info(response.getErrorCode());
    }
}
