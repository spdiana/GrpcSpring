package com.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: WalletService.proto")
public final class WalletServiceGrpc {

  private WalletServiceGrpc() {}

  public static final String SERVICE_NAME = "com.grpc.WalletService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpc.AllWallet,
      com.grpc.WalletRequest> getAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "all",
      requestType = com.grpc.AllWallet.class,
      responseType = com.grpc.WalletRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.grpc.AllWallet,
      com.grpc.WalletRequest> getAllMethod() {
    io.grpc.MethodDescriptor<com.grpc.AllWallet, com.grpc.WalletRequest> getAllMethod;
    if ((getAllMethod = WalletServiceGrpc.getAllMethod) == null) {
      synchronized (WalletServiceGrpc.class) {
        if ((getAllMethod = WalletServiceGrpc.getAllMethod) == null) {
          WalletServiceGrpc.getAllMethod = getAllMethod = 
              io.grpc.MethodDescriptor.<com.grpc.AllWallet, com.grpc.WalletRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.grpc.WalletService", "all"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.AllWallet.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.WalletRequest.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletServiceMethodDescriptorSupplier("all"))
                  .build();
          }
        }
     }
     return getAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.BalanceRequest,
      com.grpc.BalanceResponse> getBalanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "balance",
      requestType = com.grpc.BalanceRequest.class,
      responseType = com.grpc.BalanceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.BalanceRequest,
      com.grpc.BalanceResponse> getBalanceMethod() {
    io.grpc.MethodDescriptor<com.grpc.BalanceRequest, com.grpc.BalanceResponse> getBalanceMethod;
    if ((getBalanceMethod = WalletServiceGrpc.getBalanceMethod) == null) {
      synchronized (WalletServiceGrpc.class) {
        if ((getBalanceMethod = WalletServiceGrpc.getBalanceMethod) == null) {
          WalletServiceGrpc.getBalanceMethod = getBalanceMethod = 
              io.grpc.MethodDescriptor.<com.grpc.BalanceRequest, com.grpc.BalanceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.grpc.WalletService", "balance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.BalanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.BalanceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletServiceMethodDescriptorSupplier("balance"))
                  .build();
          }
        }
     }
     return getBalanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.WalletRequest,
      com.grpc.WalletResponse> getDepositMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deposit",
      requestType = com.grpc.WalletRequest.class,
      responseType = com.grpc.WalletResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.WalletRequest,
      com.grpc.WalletResponse> getDepositMethod() {
    io.grpc.MethodDescriptor<com.grpc.WalletRequest, com.grpc.WalletResponse> getDepositMethod;
    if ((getDepositMethod = WalletServiceGrpc.getDepositMethod) == null) {
      synchronized (WalletServiceGrpc.class) {
        if ((getDepositMethod = WalletServiceGrpc.getDepositMethod) == null) {
          WalletServiceGrpc.getDepositMethod = getDepositMethod = 
              io.grpc.MethodDescriptor.<com.grpc.WalletRequest, com.grpc.WalletResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.grpc.WalletService", "deposit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.WalletRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.WalletResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletServiceMethodDescriptorSupplier("deposit"))
                  .build();
          }
        }
     }
     return getDepositMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.WalletRequest,
      com.grpc.WalletResponse> getWithdrawalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "withdrawal",
      requestType = com.grpc.WalletRequest.class,
      responseType = com.grpc.WalletResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.WalletRequest,
      com.grpc.WalletResponse> getWithdrawalMethod() {
    io.grpc.MethodDescriptor<com.grpc.WalletRequest, com.grpc.WalletResponse> getWithdrawalMethod;
    if ((getWithdrawalMethod = WalletServiceGrpc.getWithdrawalMethod) == null) {
      synchronized (WalletServiceGrpc.class) {
        if ((getWithdrawalMethod = WalletServiceGrpc.getWithdrawalMethod) == null) {
          WalletServiceGrpc.getWithdrawalMethod = getWithdrawalMethod = 
              io.grpc.MethodDescriptor.<com.grpc.WalletRequest, com.grpc.WalletResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.grpc.WalletService", "withdrawal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.WalletRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.WalletResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletServiceMethodDescriptorSupplier("withdrawal"))
                  .build();
          }
        }
     }
     return getWithdrawalMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WalletServiceStub newStub(io.grpc.Channel channel) {
    return new WalletServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WalletServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WalletServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WalletServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WalletServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class WalletServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void all(com.grpc.AllWallet request,
        io.grpc.stub.StreamObserver<com.grpc.WalletRequest> responseObserver) {
      asyncUnimplementedUnaryCall(getAllMethod(), responseObserver);
    }

    /**
     */
    public void balance(com.grpc.BalanceRequest request,
        io.grpc.stub.StreamObserver<com.grpc.BalanceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getBalanceMethod(), responseObserver);
    }

    /**
     */
    public void deposit(com.grpc.WalletRequest request,
        io.grpc.stub.StreamObserver<com.grpc.WalletResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDepositMethod(), responseObserver);
    }

    /**
     */
    public void withdrawal(com.grpc.WalletRequest request,
        io.grpc.stub.StreamObserver<com.grpc.WalletResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getWithdrawalMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAllMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.grpc.AllWallet,
                com.grpc.WalletRequest>(
                  this, METHODID_ALL)))
          .addMethod(
            getBalanceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.BalanceRequest,
                com.grpc.BalanceResponse>(
                  this, METHODID_BALANCE)))
          .addMethod(
            getDepositMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.WalletRequest,
                com.grpc.WalletResponse>(
                  this, METHODID_DEPOSIT)))
          .addMethod(
            getWithdrawalMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.WalletRequest,
                com.grpc.WalletResponse>(
                  this, METHODID_WITHDRAWAL)))
          .build();
    }
  }

  /**
   */
  public static final class WalletServiceStub extends io.grpc.stub.AbstractStub<WalletServiceStub> {
    private WalletServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WalletServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WalletServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WalletServiceStub(channel, callOptions);
    }

    /**
     */
    public void all(com.grpc.AllWallet request,
        io.grpc.stub.StreamObserver<com.grpc.WalletRequest> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void balance(com.grpc.BalanceRequest request,
        io.grpc.stub.StreamObserver<com.grpc.BalanceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBalanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deposit(com.grpc.WalletRequest request,
        io.grpc.stub.StreamObserver<com.grpc.WalletResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDepositMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void withdrawal(com.grpc.WalletRequest request,
        io.grpc.stub.StreamObserver<com.grpc.WalletResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWithdrawalMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WalletServiceBlockingStub extends io.grpc.stub.AbstractStub<WalletServiceBlockingStub> {
    private WalletServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WalletServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WalletServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WalletServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.grpc.WalletRequest> all(
        com.grpc.AllWallet request) {
      return blockingServerStreamingCall(
          getChannel(), getAllMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.BalanceResponse balance(com.grpc.BalanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getBalanceMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.WalletResponse deposit(com.grpc.WalletRequest request) {
      return blockingUnaryCall(
          getChannel(), getDepositMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.WalletResponse withdrawal(com.grpc.WalletRequest request) {
      return blockingUnaryCall(
          getChannel(), getWithdrawalMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WalletServiceFutureStub extends io.grpc.stub.AbstractStub<WalletServiceFutureStub> {
    private WalletServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WalletServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WalletServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WalletServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.BalanceResponse> balance(
        com.grpc.BalanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBalanceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.WalletResponse> deposit(
        com.grpc.WalletRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDepositMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.WalletResponse> withdrawal(
        com.grpc.WalletRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWithdrawalMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ALL = 0;
  private static final int METHODID_BALANCE = 1;
  private static final int METHODID_DEPOSIT = 2;
  private static final int METHODID_WITHDRAWAL = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WalletServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WalletServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ALL:
          serviceImpl.all((com.grpc.AllWallet) request,
              (io.grpc.stub.StreamObserver<com.grpc.WalletRequest>) responseObserver);
          break;
        case METHODID_BALANCE:
          serviceImpl.balance((com.grpc.BalanceRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.BalanceResponse>) responseObserver);
          break;
        case METHODID_DEPOSIT:
          serviceImpl.deposit((com.grpc.WalletRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.WalletResponse>) responseObserver);
          break;
        case METHODID_WITHDRAWAL:
          serviceImpl.withdrawal((com.grpc.WalletRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.WalletResponse>) responseObserver);
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

  private static abstract class WalletServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WalletServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.WalletServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WalletService");
    }
  }

  private static final class WalletServiceFileDescriptorSupplier
      extends WalletServiceBaseDescriptorSupplier {
    WalletServiceFileDescriptorSupplier() {}
  }

  private static final class WalletServiceMethodDescriptorSupplier
      extends WalletServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WalletServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (WalletServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WalletServiceFileDescriptorSupplier())
              .addMethod(getAllMethod())
              .addMethod(getBalanceMethod())
              .addMethod(getDepositMethod())
              .addMethod(getWithdrawalMethod())
              .build();
        }
      }
    }
    return result;
  }
}
