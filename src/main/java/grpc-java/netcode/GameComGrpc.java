package grpc;

import netcode.Netcode;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */

public final class GameComGrpc {

  private GameComGrpc() {}

  public static final String SERVICE_NAME = "netcode.GameCom";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Netcode.MatchRequest,
      Netcode.MatchResponse> METHOD_NEW_MATCH =
      io.grpc.MethodDescriptor.<Netcode.MatchRequest, Netcode.MatchResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "NewMatch"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.MatchRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.MatchResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Netcode.TurnRequest,
      Netcode.TurnResponse> METHOD_SUBMIT_TURN =
      io.grpc.MethodDescriptor.<Netcode.TurnRequest, Netcode.TurnResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "SubmitTurn"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.TurnRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.TurnResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Netcode.MatchIDPacket,
      Netcode.GameStateResponse> METHOD_GET_GAME_STATE =
      io.grpc.MethodDescriptor.<Netcode.MatchIDPacket, Netcode.GameStateResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "GetGameState"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.MatchIDPacket.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.GameStateResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Netcode.MatchIDPacket,
      Netcode.GetTimeoutResponse> METHOD_GET_TIMEOUT =
      io.grpc.MethodDescriptor.<Netcode.MatchIDPacket, Netcode.GetTimeoutResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "GetTimeout"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.MatchIDPacket.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.GetTimeoutResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Netcode.MatchIDPacket,
      Netcode.OpponentInfoResponse> METHOD_GET_OPPONENT_INFO =
      io.grpc.MethodDescriptor.<Netcode.MatchIDPacket, Netcode.OpponentInfoResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "GetOpponentInfo"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.MatchIDPacket.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.OpponentInfoResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Netcode.MatchIDPacket,
      Netcode.Nothing> METHOD_ABORT_MATCH =
      io.grpc.MethodDescriptor.<Netcode.MatchIDPacket, Netcode.Nothing>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "AbortMatch"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.MatchIDPacket.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.Nothing.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Netcode.IDPacket,
      Netcode.EloValues> METHOD_GET_ELO =
      io.grpc.MethodDescriptor.<Netcode.IDPacket, Netcode.EloValues>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "GetElo"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.IDPacket.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.EloValues.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Netcode.UserRegistrationRequest,
      Netcode.UserRegistrationResponse> METHOD_USER_REGISTRATION =
      io.grpc.MethodDescriptor.<Netcode.UserRegistrationRequest, Netcode.UserRegistrationResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "UserRegistration"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.UserRegistrationRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.UserRegistrationResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Netcode.GroupRegistrationRequest,
      Netcode.GroupRegistrationResponse> METHOD_GROUP_REGISTRATION =
      io.grpc.MethodDescriptor.<Netcode.GroupRegistrationRequest, Netcode.GroupRegistrationResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "GroupRegistration"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.GroupRegistrationRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.GroupRegistrationResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Netcode.SetPseudonymRequest,
      Netcode.SetPseudonymResponse> METHOD_SET_GROUP_PSEUDONYM =
      io.grpc.MethodDescriptor.<Netcode.SetPseudonymRequest, Netcode.SetPseudonymResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "SetGroupPseudonym"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.SetPseudonymRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.SetPseudonymResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Netcode.SetPseudonymRequest,
      Netcode.SetPseudonymResponse> METHOD_SET_USER_PSEUDONYM =
      io.grpc.MethodDescriptor.<Netcode.SetPseudonymRequest, Netcode.SetPseudonymResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "SetUserPseudonym"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.SetPseudonymRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.SetPseudonymResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Netcode.AuthPacket,
      Netcode.GetUserTokenResponse> METHOD_GET_USER_TOKEN =
      io.grpc.MethodDescriptor.<Netcode.AuthPacket, Netcode.GetUserTokenResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "netcode.GameCom", "GetUserToken"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.AuthPacket.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Netcode.GetUserTokenResponse.getDefaultInstance()))
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
    public void newMatch(Netcode.MatchRequest request,
                         io.grpc.stub.StreamObserver<Netcode.MatchResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_NEW_MATCH, responseObserver);
    }

    /**
     */
    public void submitTurn(Netcode.TurnRequest request,
                           io.grpc.stub.StreamObserver<Netcode.TurnResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SUBMIT_TURN, responseObserver);
    }

    /**
     */
    public void getGameState(Netcode.MatchIDPacket request,
                             io.grpc.stub.StreamObserver<Netcode.GameStateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_GAME_STATE, responseObserver);
    }

    /**
     */
    public void getTimeout(Netcode.MatchIDPacket request,
                           io.grpc.stub.StreamObserver<Netcode.GetTimeoutResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_TIMEOUT, responseObserver);
    }

    /**
     */
    public void getOpponentInfo(Netcode.MatchIDPacket request,
                                io.grpc.stub.StreamObserver<Netcode.OpponentInfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_OPPONENT_INFO, responseObserver);
    }

    /**
     * <pre>
     * Disabled
     * </pre>
     */
    public void abortMatch(Netcode.MatchIDPacket request,
                           io.grpc.stub.StreamObserver<Netcode.Nothing> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ABORT_MATCH, responseObserver);
    }

    /**
     */
    public void getElo(Netcode.IDPacket request,
                       io.grpc.stub.StreamObserver<Netcode.EloValues> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ELO, responseObserver);
    }

    /**
     * <pre>
     * Organisation-related
     * </pre>
     */
    public void userRegistration(Netcode.UserRegistrationRequest request,
                                 io.grpc.stub.StreamObserver<Netcode.UserRegistrationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_USER_REGISTRATION, responseObserver);
    }

    /**
     */
    public void groupRegistration(Netcode.GroupRegistrationRequest request,
                                  io.grpc.stub.StreamObserver<Netcode.GroupRegistrationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GROUP_REGISTRATION, responseObserver);
    }

    /**
     */
    public void setGroupPseudonym(Netcode.SetPseudonymRequest request,
                                  io.grpc.stub.StreamObserver<Netcode.SetPseudonymResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_GROUP_PSEUDONYM, responseObserver);
    }

    /**
     */
    public void setUserPseudonym(Netcode.SetPseudonymRequest request,
                                 io.grpc.stub.StreamObserver<Netcode.SetPseudonymResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_USER_PSEUDONYM, responseObserver);
    }

    /**
     */
    public void getUserToken(Netcode.AuthPacket request,
                             io.grpc.stub.StreamObserver<Netcode.GetUserTokenResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_USER_TOKEN, responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_NEW_MATCH,
            asyncUnaryCall(
              new MethodHandlers<
                Netcode.MatchRequest,
                Netcode.MatchResponse>(
                  this, METHODID_NEW_MATCH)))
          .addMethod(
            METHOD_SUBMIT_TURN,
            asyncUnaryCall(
              new MethodHandlers<
                Netcode.TurnRequest,
                Netcode.TurnResponse>(
                  this, METHODID_SUBMIT_TURN)))
          .addMethod(
            METHOD_GET_GAME_STATE,
            asyncUnaryCall(
              new MethodHandlers<
                Netcode.MatchIDPacket,
                Netcode.GameStateResponse>(
                  this, METHODID_GET_GAME_STATE)))
          .addMethod(
            METHOD_GET_TIMEOUT,
            asyncUnaryCall(
              new MethodHandlers<
                Netcode.MatchIDPacket,
                Netcode.GetTimeoutResponse>(
                  this, METHODID_GET_TIMEOUT)))
          .addMethod(
            METHOD_GET_OPPONENT_INFO,
            asyncUnaryCall(
              new MethodHandlers<
                Netcode.MatchIDPacket,
                Netcode.OpponentInfoResponse>(
                  this, METHODID_GET_OPPONENT_INFO)))
          .addMethod(
            METHOD_ABORT_MATCH,
            asyncUnaryCall(
              new MethodHandlers<
                Netcode.MatchIDPacket,
                Netcode.Nothing>(
                  this, METHODID_ABORT_MATCH)))
          .addMethod(
            METHOD_GET_ELO,
            asyncUnaryCall(
              new MethodHandlers<
                Netcode.IDPacket,
                Netcode.EloValues>(
                  this, METHODID_GET_ELO)))
          .addMethod(
            METHOD_USER_REGISTRATION,
            asyncUnaryCall(
              new MethodHandlers<
                Netcode.UserRegistrationRequest,
                Netcode.UserRegistrationResponse>(
                  this, METHODID_USER_REGISTRATION)))
          .addMethod(
            METHOD_GROUP_REGISTRATION,
            asyncUnaryCall(
              new MethodHandlers<
                Netcode.GroupRegistrationRequest,
                Netcode.GroupRegistrationResponse>(
                  this, METHODID_GROUP_REGISTRATION)))
          .addMethod(
            METHOD_SET_GROUP_PSEUDONYM,
            asyncUnaryCall(
              new MethodHandlers<
                Netcode.SetPseudonymRequest,
                Netcode.SetPseudonymResponse>(
                  this, METHODID_SET_GROUP_PSEUDONYM)))
          .addMethod(
            METHOD_SET_USER_PSEUDONYM,
            asyncUnaryCall(
              new MethodHandlers<
                Netcode.SetPseudonymRequest,
                Netcode.SetPseudonymResponse>(
                  this, METHODID_SET_USER_PSEUDONYM)))
          .addMethod(
            METHOD_GET_USER_TOKEN,
            asyncUnaryCall(
              new MethodHandlers<
                Netcode.AuthPacket,
                Netcode.GetUserTokenResponse>(
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

    @Override
    protected GameComStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GameComStub(channel, callOptions);
    }

    /**
     * <pre>
     * Game-related
     * </pre>
     */
    public void newMatch(Netcode.MatchRequest request,
                         io.grpc.stub.StreamObserver<Netcode.MatchResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_NEW_MATCH, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void submitTurn(Netcode.TurnRequest request,
                           io.grpc.stub.StreamObserver<Netcode.TurnResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SUBMIT_TURN, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getGameState(Netcode.MatchIDPacket request,
                             io.grpc.stub.StreamObserver<Netcode.GameStateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_GAME_STATE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTimeout(Netcode.MatchIDPacket request,
                           io.grpc.stub.StreamObserver<Netcode.GetTimeoutResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_TIMEOUT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getOpponentInfo(Netcode.MatchIDPacket request,
                                io.grpc.stub.StreamObserver<Netcode.OpponentInfoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_OPPONENT_INFO, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Disabled
     * </pre>
     */
    public void abortMatch(Netcode.MatchIDPacket request,
                           io.grpc.stub.StreamObserver<Netcode.Nothing> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ABORT_MATCH, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getElo(Netcode.IDPacket request,
                       io.grpc.stub.StreamObserver<Netcode.EloValues> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ELO, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Organisation-related
     * </pre>
     */
    public void userRegistration(Netcode.UserRegistrationRequest request,
                                 io.grpc.stub.StreamObserver<Netcode.UserRegistrationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_REGISTRATION, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void groupRegistration(Netcode.GroupRegistrationRequest request,
                                  io.grpc.stub.StreamObserver<Netcode.GroupRegistrationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GROUP_REGISTRATION, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setGroupPseudonym(Netcode.SetPseudonymRequest request,
                                  io.grpc.stub.StreamObserver<Netcode.SetPseudonymResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_GROUP_PSEUDONYM, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setUserPseudonym(Netcode.SetPseudonymRequest request,
                                 io.grpc.stub.StreamObserver<Netcode.SetPseudonymResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_USER_PSEUDONYM, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserToken(Netcode.AuthPacket request,
                             io.grpc.stub.StreamObserver<Netcode.GetUserTokenResponse> responseObserver) {
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

    @Override
    protected GameComBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GameComBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Game-related
     * </pre>
     */
    public Netcode.MatchResponse newMatch(Netcode.MatchRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_NEW_MATCH, getCallOptions(), request);
    }

    /**
     */
    public Netcode.TurnResponse submitTurn(Netcode.TurnRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SUBMIT_TURN, getCallOptions(), request);
    }

    /**
     */
    public Netcode.GameStateResponse getGameState(Netcode.MatchIDPacket request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_GAME_STATE, getCallOptions(), request);
    }

    /**
     */
    public Netcode.GetTimeoutResponse getTimeout(Netcode.MatchIDPacket request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_TIMEOUT, getCallOptions(), request);
    }

    /**
     */
    public Netcode.OpponentInfoResponse getOpponentInfo(Netcode.MatchIDPacket request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_OPPONENT_INFO, getCallOptions(), request);
    }

    /**
     * <pre>
     * Disabled
     * </pre>
     */
    public Netcode.Nothing abortMatch(Netcode.MatchIDPacket request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ABORT_MATCH, getCallOptions(), request);
    }

    /**
     */
    public Netcode.EloValues getElo(Netcode.IDPacket request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ELO, getCallOptions(), request);
    }

    /**
     * <pre>
     * Organisation-related
     * </pre>
     */
    public Netcode.UserRegistrationResponse userRegistration(Netcode.UserRegistrationRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_USER_REGISTRATION, getCallOptions(), request);
    }

    /**
     */
    public Netcode.GroupRegistrationResponse groupRegistration(Netcode.GroupRegistrationRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GROUP_REGISTRATION, getCallOptions(), request);
    }

    /**
     */
    public Netcode.SetPseudonymResponse setGroupPseudonym(Netcode.SetPseudonymRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_GROUP_PSEUDONYM, getCallOptions(), request);
    }

    /**
     */
    public Netcode.SetPseudonymResponse setUserPseudonym(Netcode.SetPseudonymRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_USER_PSEUDONYM, getCallOptions(), request);
    }

    /**
     */
    public Netcode.GetUserTokenResponse getUserToken(Netcode.AuthPacket request) {
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

    @Override
    protected GameComFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GameComFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Game-related
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Netcode.MatchResponse> newMatch(
        Netcode.MatchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_NEW_MATCH, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Netcode.TurnResponse> submitTurn(
        Netcode.TurnRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SUBMIT_TURN, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Netcode.GameStateResponse> getGameState(
        Netcode.MatchIDPacket request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_GAME_STATE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Netcode.GetTimeoutResponse> getTimeout(
        Netcode.MatchIDPacket request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_TIMEOUT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Netcode.OpponentInfoResponse> getOpponentInfo(
        Netcode.MatchIDPacket request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_OPPONENT_INFO, getCallOptions()), request);
    }

    /**
     * <pre>
     * Disabled
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Netcode.Nothing> abortMatch(
        Netcode.MatchIDPacket request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ABORT_MATCH, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Netcode.EloValues> getElo(
        Netcode.IDPacket request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ELO, getCallOptions()), request);
    }

    /**
     * <pre>
     * Organisation-related
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Netcode.UserRegistrationResponse> userRegistration(
        Netcode.UserRegistrationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_USER_REGISTRATION, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Netcode.GroupRegistrationResponse> groupRegistration(
        Netcode.GroupRegistrationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GROUP_REGISTRATION, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Netcode.SetPseudonymResponse> setGroupPseudonym(
        Netcode.SetPseudonymRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_GROUP_PSEUDONYM, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Netcode.SetPseudonymResponse> setUserPseudonym(
        Netcode.SetPseudonymRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_USER_PSEUDONYM, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Netcode.GetUserTokenResponse> getUserToken(
        Netcode.AuthPacket request) {
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

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_NEW_MATCH:
          serviceImpl.newMatch((Netcode.MatchRequest) request,
              (io.grpc.stub.StreamObserver<Netcode.MatchResponse>) responseObserver);
          break;
        case METHODID_SUBMIT_TURN:
          serviceImpl.submitTurn((Netcode.TurnRequest) request,
              (io.grpc.stub.StreamObserver<Netcode.TurnResponse>) responseObserver);
          break;
        case METHODID_GET_GAME_STATE:
          serviceImpl.getGameState((Netcode.MatchIDPacket) request,
              (io.grpc.stub.StreamObserver<Netcode.GameStateResponse>) responseObserver);
          break;
        case METHODID_GET_TIMEOUT:
          serviceImpl.getTimeout((Netcode.MatchIDPacket) request,
              (io.grpc.stub.StreamObserver<Netcode.GetTimeoutResponse>) responseObserver);
          break;
        case METHODID_GET_OPPONENT_INFO:
          serviceImpl.getOpponentInfo((Netcode.MatchIDPacket) request,
              (io.grpc.stub.StreamObserver<Netcode.OpponentInfoResponse>) responseObserver);
          break;
        case METHODID_ABORT_MATCH:
          serviceImpl.abortMatch((Netcode.MatchIDPacket) request,
              (io.grpc.stub.StreamObserver<Netcode.Nothing>) responseObserver);
          break;
        case METHODID_GET_ELO:
          serviceImpl.getElo((Netcode.IDPacket) request,
              (io.grpc.stub.StreamObserver<Netcode.EloValues>) responseObserver);
          break;
        case METHODID_USER_REGISTRATION:
          serviceImpl.userRegistration((Netcode.UserRegistrationRequest) request,
              (io.grpc.stub.StreamObserver<Netcode.UserRegistrationResponse>) responseObserver);
          break;
        case METHODID_GROUP_REGISTRATION:
          serviceImpl.groupRegistration((Netcode.GroupRegistrationRequest) request,
              (io.grpc.stub.StreamObserver<Netcode.GroupRegistrationResponse>) responseObserver);
          break;
        case METHODID_SET_GROUP_PSEUDONYM:
          serviceImpl.setGroupPseudonym((Netcode.SetPseudonymRequest) request,
              (io.grpc.stub.StreamObserver<Netcode.SetPseudonymResponse>) responseObserver);
          break;
        case METHODID_SET_USER_PSEUDONYM:
          serviceImpl.setUserPseudonym((Netcode.SetPseudonymRequest) request,
              (io.grpc.stub.StreamObserver<Netcode.SetPseudonymResponse>) responseObserver);
          break;
        case METHODID_GET_USER_TOKEN:
          serviceImpl.getUserToken((Netcode.AuthPacket) request,
              (io.grpc.stub.StreamObserver<Netcode.GetUserTokenResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class GameComDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Netcode.getDescriptor();
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
