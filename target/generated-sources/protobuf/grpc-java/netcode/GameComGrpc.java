package netcode;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */

public final class GameComGrpc {

  private GameComGrpc() {}

  public static final String SERVICE_NAME = "netcode.GameCom";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<netcode.Netcode.MatchRequest,
      netcode.Netcode.MatchResponse> METHOD_NEW_MATCH =
      io.grpc.MethodDescriptor.<netcode.Netcode.MatchRequest, netcode.Netcode.MatchResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "NewMatch"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.MatchRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.MatchResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<netcode.Netcode.TurnRequest,
      netcode.Netcode.TurnResponse> METHOD_SUBMIT_TURN =
      io.grpc.MethodDescriptor.<netcode.Netcode.TurnRequest, netcode.Netcode.TurnResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "SubmitTurn"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.TurnRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.TurnResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<netcode.Netcode.MatchIDPacket,
      netcode.Netcode.GameStateResponse> METHOD_GET_GAME_STATE =
      io.grpc.MethodDescriptor.<netcode.Netcode.MatchIDPacket, netcode.Netcode.GameStateResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "GetGameState"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.MatchIDPacket.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.GameStateResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<netcode.Netcode.MatchIDPacket,
      netcode.Netcode.GetTimeoutResponse> METHOD_GET_TIMEOUT =
      io.grpc.MethodDescriptor.<netcode.Netcode.MatchIDPacket, netcode.Netcode.GetTimeoutResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "GetTimeout"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.MatchIDPacket.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.GetTimeoutResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<netcode.Netcode.MatchIDPacket,
      netcode.Netcode.OpponentInfoResponse> METHOD_GET_OPPONENT_INFO =
      io.grpc.MethodDescriptor.<netcode.Netcode.MatchIDPacket, netcode.Netcode.OpponentInfoResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "GetOpponentInfo"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.MatchIDPacket.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.OpponentInfoResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<netcode.Netcode.MatchIDPacket,
      netcode.Netcode.Nothing> METHOD_ABORT_MATCH =
      io.grpc.MethodDescriptor.<netcode.Netcode.MatchIDPacket, netcode.Netcode.Nothing>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "AbortMatch"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.MatchIDPacket.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.Nothing.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<netcode.Netcode.IDPacket,
      netcode.Netcode.EloValues> METHOD_GET_ELO =
      io.grpc.MethodDescriptor.<netcode.Netcode.IDPacket, netcode.Netcode.EloValues>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "GetElo"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.IDPacket.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.EloValues.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<netcode.Netcode.UserRegistrationRequest,
      netcode.Netcode.UserRegistrationResponse> METHOD_USER_REGISTRATION =
      io.grpc.MethodDescriptor.<netcode.Netcode.UserRegistrationRequest, netcode.Netcode.UserRegistrationResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "UserRegistration"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.UserRegistrationRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.UserRegistrationResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<netcode.Netcode.GroupRegistrationRequest,
      netcode.Netcode.GroupRegistrationResponse> METHOD_GROUP_REGISTRATION =
      io.grpc.MethodDescriptor.<netcode.Netcode.GroupRegistrationRequest, netcode.Netcode.GroupRegistrationResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "GroupRegistration"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.GroupRegistrationRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.GroupRegistrationResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<netcode.Netcode.SetPseudonymRequest,
      netcode.Netcode.SetPseudonymResponse> METHOD_SET_GROUP_PSEUDONYM =
      io.grpc.MethodDescriptor.<netcode.Netcode.SetPseudonymRequest, netcode.Netcode.SetPseudonymResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "SetGroupPseudonym"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.SetPseudonymRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.SetPseudonymResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<netcode.Netcode.SetPseudonymRequest,
      netcode.Netcode.SetPseudonymResponse> METHOD_SET_USER_PSEUDONYM =
      io.grpc.MethodDescriptor.<netcode.Netcode.SetPseudonymRequest, netcode.Netcode.SetPseudonymResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "SetUserPseudonym"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.SetPseudonymRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.SetPseudonymResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<netcode.Netcode.AuthPacket,
      netcode.Netcode.GetUserTokenResponse> METHOD_GET_USER_TOKEN =
      io.grpc.MethodDescriptor.<netcode.Netcode.AuthPacket, netcode.Netcode.GetUserTokenResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "GetUserToken"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.AuthPacket.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              netcode.Netcode.GetUserTokenResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GameComStub newStub(io.grpc.Channel channel) {
    return new GameComStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GameComBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GameComBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GameComFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GameComFutureStub(channel);
  }

  /**
   */
  public static abstract class GameComImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Game-related
     * </pre>
     */
    public void newMatch(netcode.Netcode.MatchRequest request,
        io.grpc.stub.StreamObserver<netcode.Netcode.MatchResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_NEW_MATCH, responseObserver);
    }

    /**
     */
    public void submitTurn(netcode.Netcode.TurnRequest request,
        io.grpc.stub.StreamObserver<netcode.Netcode.TurnResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SUBMIT_TURN, responseObserver);
    }

    /**
     */
    public void getGameState(netcode.Netcode.MatchIDPacket request,
        io.grpc.stub.StreamObserver<netcode.Netcode.GameStateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_GAME_STATE, responseObserver);
    }

    /**
     */
    public void getTimeout(netcode.Netcode.MatchIDPacket request,
        io.grpc.stub.StreamObserver<netcode.Netcode.GetTimeoutResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_TIMEOUT, responseObserver);
    }

    /**
     */
    public void getOpponentInfo(netcode.Netcode.MatchIDPacket request,
        io.grpc.stub.StreamObserver<netcode.Netcode.OpponentInfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_OPPONENT_INFO, responseObserver);
    }

    /**
     * <pre>
     * Disabled
     * </pre>
     */
    public void abortMatch(netcode.Netcode.MatchIDPacket request,
        io.grpc.stub.StreamObserver<netcode.Netcode.Nothing> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ABORT_MATCH, responseObserver);
    }

    /**
     */
    public void getElo(netcode.Netcode.IDPacket request,
        io.grpc.stub.StreamObserver<netcode.Netcode.EloValues> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ELO, responseObserver);
    }

    /**
     * <pre>
     * Organisation-related
     * </pre>
     */
    public void userRegistration(netcode.Netcode.UserRegistrationRequest request,
        io.grpc.stub.StreamObserver<netcode.Netcode.UserRegistrationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_USER_REGISTRATION, responseObserver);
    }

    /**
     */
    public void groupRegistration(netcode.Netcode.GroupRegistrationRequest request,
        io.grpc.stub.StreamObserver<netcode.Netcode.GroupRegistrationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GROUP_REGISTRATION, responseObserver);
    }

    /**
     */
    public void setGroupPseudonym(netcode.Netcode.SetPseudonymRequest request,
        io.grpc.stub.StreamObserver<netcode.Netcode.SetPseudonymResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_GROUP_PSEUDONYM, responseObserver);
    }

    /**
     */
    public void setUserPseudonym(netcode.Netcode.SetPseudonymRequest request,
        io.grpc.stub.StreamObserver<netcode.Netcode.SetPseudonymResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_USER_PSEUDONYM, responseObserver);
    }

    /**
     */
    public void getUserToken(netcode.Netcode.AuthPacket request,
        io.grpc.stub.StreamObserver<netcode.Netcode.GetUserTokenResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_USER_TOKEN, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_NEW_MATCH,
            asyncUnaryCall(
              new MethodHandlers<
                netcode.Netcode.MatchRequest,
                netcode.Netcode.MatchResponse>(
                  this, METHODID_NEW_MATCH)))
          .addMethod(
            METHOD_SUBMIT_TURN,
            asyncUnaryCall(
              new MethodHandlers<
                netcode.Netcode.TurnRequest,
                netcode.Netcode.TurnResponse>(
                  this, METHODID_SUBMIT_TURN)))
          .addMethod(
            METHOD_GET_GAME_STATE,
            asyncUnaryCall(
              new MethodHandlers<
                netcode.Netcode.MatchIDPacket,
                netcode.Netcode.GameStateResponse>(
                  this, METHODID_GET_GAME_STATE)))
          .addMethod(
            METHOD_GET_TIMEOUT,
            asyncUnaryCall(
              new MethodHandlers<
                netcode.Netcode.MatchIDPacket,
                netcode.Netcode.GetTimeoutResponse>(
                  this, METHODID_GET_TIMEOUT)))
          .addMethod(
            METHOD_GET_OPPONENT_INFO,
            asyncUnaryCall(
              new MethodHandlers<
                netcode.Netcode.MatchIDPacket,
                netcode.Netcode.OpponentInfoResponse>(
                  this, METHODID_GET_OPPONENT_INFO)))
          .addMethod(
            METHOD_ABORT_MATCH,
            asyncUnaryCall(
              new MethodHandlers<
                netcode.Netcode.MatchIDPacket,
                netcode.Netcode.Nothing>(
                  this, METHODID_ABORT_MATCH)))
          .addMethod(
            METHOD_GET_ELO,
            asyncUnaryCall(
              new MethodHandlers<
                netcode.Netcode.IDPacket,
                netcode.Netcode.EloValues>(
                  this, METHODID_GET_ELO)))
          .addMethod(
            METHOD_USER_REGISTRATION,
            asyncUnaryCall(
              new MethodHandlers<
                netcode.Netcode.UserRegistrationRequest,
                netcode.Netcode.UserRegistrationResponse>(
                  this, METHODID_USER_REGISTRATION)))
          .addMethod(
            METHOD_GROUP_REGISTRATION,
            asyncUnaryCall(
              new MethodHandlers<
                netcode.Netcode.GroupRegistrationRequest,
                netcode.Netcode.GroupRegistrationResponse>(
                  this, METHODID_GROUP_REGISTRATION)))
          .addMethod(
            METHOD_SET_GROUP_PSEUDONYM,
            asyncUnaryCall(
              new MethodHandlers<
                netcode.Netcode.SetPseudonymRequest,
                netcode.Netcode.SetPseudonymResponse>(
                  this, METHODID_SET_GROUP_PSEUDONYM)))
          .addMethod(
            METHOD_SET_USER_PSEUDONYM,
            asyncUnaryCall(
              new MethodHandlers<
                netcode.Netcode.SetPseudonymRequest,
                netcode.Netcode.SetPseudonymResponse>(
                  this, METHODID_SET_USER_PSEUDONYM)))
          .addMethod(
            METHOD_GET_USER_TOKEN,
            asyncUnaryCall(
              new MethodHandlers<
                netcode.Netcode.AuthPacket,
                netcode.Netcode.GetUserTokenResponse>(
                  this, METHODID_GET_USER_TOKEN)))
          .build();
    }
  }

  /**
   */
  public static final class GameComStub extends io.grpc.stub.AbstractStub<GameComStub> {
    private GameComStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GameComStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameComStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GameComStub(channel, callOptions);
    }

    /**
     * <pre>
     * Game-related
     * </pre>
     */
    public void newMatch(netcode.Netcode.MatchRequest request,
        io.grpc.stub.StreamObserver<netcode.Netcode.MatchResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_NEW_MATCH, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void submitTurn(netcode.Netcode.TurnRequest request,
        io.grpc.stub.StreamObserver<netcode.Netcode.TurnResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SUBMIT_TURN, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getGameState(netcode.Netcode.MatchIDPacket request,
        io.grpc.stub.StreamObserver<netcode.Netcode.GameStateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_GAME_STATE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTimeout(netcode.Netcode.MatchIDPacket request,
        io.grpc.stub.StreamObserver<netcode.Netcode.GetTimeoutResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_TIMEOUT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getOpponentInfo(netcode.Netcode.MatchIDPacket request,
        io.grpc.stub.StreamObserver<netcode.Netcode.OpponentInfoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_OPPONENT_INFO, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Disabled
     * </pre>
     */
    public void abortMatch(netcode.Netcode.MatchIDPacket request,
        io.grpc.stub.StreamObserver<netcode.Netcode.Nothing> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ABORT_MATCH, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getElo(netcode.Netcode.IDPacket request,
        io.grpc.stub.StreamObserver<netcode.Netcode.EloValues> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ELO, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Organisation-related
     * </pre>
     */
    public void userRegistration(netcode.Netcode.UserRegistrationRequest request,
        io.grpc.stub.StreamObserver<netcode.Netcode.UserRegistrationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_REGISTRATION, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void groupRegistration(netcode.Netcode.GroupRegistrationRequest request,
        io.grpc.stub.StreamObserver<netcode.Netcode.GroupRegistrationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GROUP_REGISTRATION, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setGroupPseudonym(netcode.Netcode.SetPseudonymRequest request,
        io.grpc.stub.StreamObserver<netcode.Netcode.SetPseudonymResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_GROUP_PSEUDONYM, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setUserPseudonym(netcode.Netcode.SetPseudonymRequest request,
        io.grpc.stub.StreamObserver<netcode.Netcode.SetPseudonymResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_USER_PSEUDONYM, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserToken(netcode.Netcode.AuthPacket request,
        io.grpc.stub.StreamObserver<netcode.Netcode.GetUserTokenResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_USER_TOKEN, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GameComBlockingStub extends io.grpc.stub.AbstractStub<GameComBlockingStub> {
    private GameComBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GameComBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameComBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GameComBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Game-related
     * </pre>
     */
    public netcode.Netcode.MatchResponse newMatch(netcode.Netcode.MatchRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_NEW_MATCH, getCallOptions(), request);
    }

    /**
     */
    public netcode.Netcode.TurnResponse submitTurn(netcode.Netcode.TurnRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SUBMIT_TURN, getCallOptions(), request);
    }

    /**
     */
    public netcode.Netcode.GameStateResponse getGameState(netcode.Netcode.MatchIDPacket request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_GAME_STATE, getCallOptions(), request);
    }

    /**
     */
    public netcode.Netcode.GetTimeoutResponse getTimeout(netcode.Netcode.MatchIDPacket request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_TIMEOUT, getCallOptions(), request);
    }

    /**
     */
    public netcode.Netcode.OpponentInfoResponse getOpponentInfo(netcode.Netcode.MatchIDPacket request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_OPPONENT_INFO, getCallOptions(), request);
    }

    /**
     * <pre>
     * Disabled
     * </pre>
     */
    public netcode.Netcode.Nothing abortMatch(netcode.Netcode.MatchIDPacket request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ABORT_MATCH, getCallOptions(), request);
    }

    /**
     */
    public netcode.Netcode.EloValues getElo(netcode.Netcode.IDPacket request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ELO, getCallOptions(), request);
    }

    /**
     * <pre>
     * Organisation-related
     * </pre>
     */
    public netcode.Netcode.UserRegistrationResponse userRegistration(netcode.Netcode.UserRegistrationRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_USER_REGISTRATION, getCallOptions(), request);
    }

    /**
     */
    public netcode.Netcode.GroupRegistrationResponse groupRegistration(netcode.Netcode.GroupRegistrationRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GROUP_REGISTRATION, getCallOptions(), request);
    }

    /**
     */
    public netcode.Netcode.SetPseudonymResponse setGroupPseudonym(netcode.Netcode.SetPseudonymRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_GROUP_PSEUDONYM, getCallOptions(), request);
    }

    /**
     */
    public netcode.Netcode.SetPseudonymResponse setUserPseudonym(netcode.Netcode.SetPseudonymRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_USER_PSEUDONYM, getCallOptions(), request);
    }

    /**
     */
    public netcode.Netcode.GetUserTokenResponse getUserToken(netcode.Netcode.AuthPacket request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_USER_TOKEN, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GameComFutureStub extends io.grpc.stub.AbstractStub<GameComFutureStub> {
    private GameComFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GameComFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameComFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GameComFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Game-related
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<netcode.Netcode.MatchResponse> newMatch(
        netcode.Netcode.MatchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_NEW_MATCH, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<netcode.Netcode.TurnResponse> submitTurn(
        netcode.Netcode.TurnRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SUBMIT_TURN, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<netcode.Netcode.GameStateResponse> getGameState(
        netcode.Netcode.MatchIDPacket request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_GAME_STATE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<netcode.Netcode.GetTimeoutResponse> getTimeout(
        netcode.Netcode.MatchIDPacket request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_TIMEOUT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<netcode.Netcode.OpponentInfoResponse> getOpponentInfo(
        netcode.Netcode.MatchIDPacket request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_OPPONENT_INFO, getCallOptions()), request);
    }

    /**
     * <pre>
     * Disabled
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<netcode.Netcode.Nothing> abortMatch(
        netcode.Netcode.MatchIDPacket request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ABORT_MATCH, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<netcode.Netcode.EloValues> getElo(
        netcode.Netcode.IDPacket request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ELO, getCallOptions()), request);
    }

    /**
     * <pre>
     * Organisation-related
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<netcode.Netcode.UserRegistrationResponse> userRegistration(
        netcode.Netcode.UserRegistrationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_USER_REGISTRATION, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<netcode.Netcode.GroupRegistrationResponse> groupRegistration(
        netcode.Netcode.GroupRegistrationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GROUP_REGISTRATION, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<netcode.Netcode.SetPseudonymResponse> setGroupPseudonym(
        netcode.Netcode.SetPseudonymRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_GROUP_PSEUDONYM, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<netcode.Netcode.SetPseudonymResponse> setUserPseudonym(
        netcode.Netcode.SetPseudonymRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_USER_PSEUDONYM, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<netcode.Netcode.GetUserTokenResponse> getUserToken(
        netcode.Netcode.AuthPacket request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_USER_TOKEN, getCallOptions()), request);
    }
  }

  private static final int METHODID_NEW_MATCH = 0;
  private static final int METHODID_SUBMIT_TURN = 1;
  private static final int METHODID_GET_GAME_STATE = 2;
  private static final int METHODID_GET_TIMEOUT = 3;
  private static final int METHODID_GET_OPPONENT_INFO = 4;
  private static final int METHODID_ABORT_MATCH = 5;
  private static final int METHODID_GET_ELO = 6;
  private static final int METHODID_USER_REGISTRATION = 7;
  private static final int METHODID_GROUP_REGISTRATION = 8;
  private static final int METHODID_SET_GROUP_PSEUDONYM = 9;
  private static final int METHODID_SET_USER_PSEUDONYM = 10;
  private static final int METHODID_GET_USER_TOKEN = 11;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GameComImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GameComImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_NEW_MATCH:
          serviceImpl.newMatch((netcode.Netcode.MatchRequest) request,
              (io.grpc.stub.StreamObserver<netcode.Netcode.MatchResponse>) responseObserver);
          break;
        case METHODID_SUBMIT_TURN:
          serviceImpl.submitTurn((netcode.Netcode.TurnRequest) request,
              (io.grpc.stub.StreamObserver<netcode.Netcode.TurnResponse>) responseObserver);
          break;
        case METHODID_GET_GAME_STATE:
          serviceImpl.getGameState((netcode.Netcode.MatchIDPacket) request,
              (io.grpc.stub.StreamObserver<netcode.Netcode.GameStateResponse>) responseObserver);
          break;
        case METHODID_GET_TIMEOUT:
          serviceImpl.getTimeout((netcode.Netcode.MatchIDPacket) request,
              (io.grpc.stub.StreamObserver<netcode.Netcode.GetTimeoutResponse>) responseObserver);
          break;
        case METHODID_GET_OPPONENT_INFO:
          serviceImpl.getOpponentInfo((netcode.Netcode.MatchIDPacket) request,
              (io.grpc.stub.StreamObserver<netcode.Netcode.OpponentInfoResponse>) responseObserver);
          break;
        case METHODID_ABORT_MATCH:
          serviceImpl.abortMatch((netcode.Netcode.MatchIDPacket) request,
              (io.grpc.stub.StreamObserver<netcode.Netcode.Nothing>) responseObserver);
          break;
        case METHODID_GET_ELO:
          serviceImpl.getElo((netcode.Netcode.IDPacket) request,
              (io.grpc.stub.StreamObserver<netcode.Netcode.EloValues>) responseObserver);
          break;
        case METHODID_USER_REGISTRATION:
          serviceImpl.userRegistration((netcode.Netcode.UserRegistrationRequest) request,
              (io.grpc.stub.StreamObserver<netcode.Netcode.UserRegistrationResponse>) responseObserver);
          break;
        case METHODID_GROUP_REGISTRATION:
          serviceImpl.groupRegistration((netcode.Netcode.GroupRegistrationRequest) request,
              (io.grpc.stub.StreamObserver<netcode.Netcode.GroupRegistrationResponse>) responseObserver);
          break;
        case METHODID_SET_GROUP_PSEUDONYM:
          serviceImpl.setGroupPseudonym((netcode.Netcode.SetPseudonymRequest) request,
              (io.grpc.stub.StreamObserver<netcode.Netcode.SetPseudonymResponse>) responseObserver);
          break;
        case METHODID_SET_USER_PSEUDONYM:
          serviceImpl.setUserPseudonym((netcode.Netcode.SetPseudonymRequest) request,
              (io.grpc.stub.StreamObserver<netcode.Netcode.SetPseudonymResponse>) responseObserver);
          break;
        case METHODID_GET_USER_TOKEN:
          serviceImpl.getUserToken((netcode.Netcode.AuthPacket) request,
              (io.grpc.stub.StreamObserver<netcode.Netcode.GetUserTokenResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class GameComDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return netcode.Netcode.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GameComGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GameComDescriptorSupplier())
              .addMethod(METHOD_NEW_MATCH)
              .addMethod(METHOD_SUBMIT_TURN)
              .addMethod(METHOD_GET_GAME_STATE)
              .addMethod(METHOD_GET_TIMEOUT)
              .addMethod(METHOD_GET_OPPONENT_INFO)
              .addMethod(METHOD_ABORT_MATCH)
              .addMethod(METHOD_GET_ELO)
              .addMethod(METHOD_USER_REGISTRATION)
              .addMethod(METHOD_GROUP_REGISTRATION)
              .addMethod(METHOD_SET_GROUP_PSEUDONYM)
              .addMethod(METHOD_SET_USER_PSEUDONYM)
              .addMethod(METHOD_GET_USER_TOKEN)
              .build();
        }
      }
    }
    return result;
  }
}
