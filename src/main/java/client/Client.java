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

    private static final String USER_TOKEN = "0257a1c7ca11b86ced99b145be9fe470e97ef255f3ebd8d49314d7dc34abc797";
    private static final String GAME_TOKEN = "tak";

    private final GameComGrpc.GameComBlockingStub stub;

    private Netcode.MatchIDPacket matchIDPacket;

    public Client() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(HOST, PORT)
                .usePlaintext()
                .build();
        stub = GameComGrpc.newBlockingStub(channel);
    }

    public void initMatchIDPacket(String matchToken) {
        matchIDPacket = Netcode.MatchIDPacket.newBuilder()
                .setUserToken(USER_TOKEN)
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

    public Netcode.MatchResponse createMatchRequest(int boardLength,  int timeout) {
        Tak.GameParameter gameParameter = Tak.GameParameter.newBuilder()
                .setBoardLength(boardLength)
                .build();
        Netcode.MatchRequest request  = Netcode.MatchRequest.newBuilder()
                .setUserToken(USER_TOKEN)
                .setGameToken(GAME_TOKEN)
                .setTimeoutSuggestionSeconds(timeout)
                .setTakGameParameters(gameParameter)
                .build();
        return stub.newMatch(request);
    }

    public Netcode.MatchResponse createDirectMatchRequest(int boardLength, int timeout, String opponent) {
        Tak.GameParameter gameParameter = Tak.GameParameter.newBuilder()
                .setBoardLength(boardLength)
                .build();

        Netcode.DirectChallenge directChallenge = Netcode.DirectChallenge.newBuilder()
                .setUserPseudonym(opponent)
                .build();

        Netcode.MatchmakingParameter matchmakingParameter = Netcode.MatchmakingParameter.newBuilder()
                .setDirectMatchmaking(directChallenge)
                .build();

        Netcode.MatchRequest request  = Netcode.MatchRequest.newBuilder()
                .setUserToken(USER_TOKEN)
                .setGameToken(GAME_TOKEN)
                .setMatchmakingParameters(matchmakingParameter)
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

    public void setUserPseudonym() {
        Netcode.AuthPacket authPacket = Netcode.AuthPacket.newBuilder()
                .setMatrNumber("matrnummer")
                .setSecret("algopassword")
                .build();

        Netcode.SetPseudonymRequest request =  Netcode.SetPseudonymRequest.newBuilder()
                .setAuth(authPacket)
                .setPseudonym("")
                .build();
        // mario: lenk
        // hasan: hazan
        // baki: clozopin
        Netcode.SetPseudonymResponse response =  stub.setUserPseudonym(request);
        logger.info(response.getErrorCode());
    }

}
