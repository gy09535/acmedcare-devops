package com.acmedcare.framework.devops.endpoint.center;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import io.grpc.stub.ClientCalls;

/**
 * <pre>
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.24.0)",
    comments = "Source: control_center.proto")
public final class ControllerCenterGrpc {

  private ControllerCenterGrpc() {}

  public static final String SERVICE_NAME = "com.acmedcare.framework.devops.endpoint.center.ControllerCenter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor< Service,
       Result> getRegisterServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "registerService",
      requestType =  Service.class,
      responseType =  Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor< Service,
       Result> getRegisterServiceMethod() {
    io.grpc.MethodDescriptor< Service,  Result> getRegisterServiceMethod;
    if ((getRegisterServiceMethod = ControllerCenterGrpc.getRegisterServiceMethod) == null) {
      synchronized (ControllerCenterGrpc.class) {
        if ((getRegisterServiceMethod = ControllerCenterGrpc.getRegisterServiceMethod) == null) {
          ControllerCenterGrpc.getRegisterServiceMethod = getRegisterServiceMethod =
              io.grpc.MethodDescriptor.< Service,  Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "registerService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                   Service.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                   Result.getDefaultInstance()))
              .setSchemaDescriptor(new ControllerCenterMethodDescriptorSupplier("registerService"))
              .build();
        }
      }
    }
    return getRegisterServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor< HeartBeat,
       Result> getReportHeartBeatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "reportHeartBeat",
      requestType =  HeartBeat.class,
      responseType =  Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor< HeartBeat,
       Result> getReportHeartBeatMethod() {
    io.grpc.MethodDescriptor< HeartBeat,  Result> getReportHeartBeatMethod;
    if ((getReportHeartBeatMethod = ControllerCenterGrpc.getReportHeartBeatMethod) == null) {
      synchronized (ControllerCenterGrpc.class) {
        if ((getReportHeartBeatMethod = ControllerCenterGrpc.getReportHeartBeatMethod) == null) {
          ControllerCenterGrpc.getReportHeartBeatMethod = getReportHeartBeatMethod =
              io.grpc.MethodDescriptor.< HeartBeat,  Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "reportHeartBeat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                   HeartBeat.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                   Result.getDefaultInstance()))
              .setSchemaDescriptor(new ControllerCenterMethodDescriptorSupplier("reportHeartBeat"))
              .build();
        }
      }
    }
    return getReportHeartBeatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ControllerCenterStub newStub(io.grpc.Channel channel) {
    return new ControllerCenterStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ControllerCenterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ControllerCenterBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ControllerCenterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ControllerCenterFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class ControllerCenterImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void registerService( Service request,
        io.grpc.stub.StreamObserver< Result> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterServiceMethod(), responseObserver);
    }

    /**
     */
    public void reportHeartBeat( HeartBeat request,
        io.grpc.stub.StreamObserver< Result> responseObserver) {
      asyncUnimplementedUnaryCall(getReportHeartBeatMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterServiceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                 Service,
                 Result>(
                  this, METHODID_REGISTER_SERVICE)))
          .addMethod(
            getReportHeartBeatMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                 HeartBeat,
                 Result>(
                  this, METHODID_REPORT_HEART_BEAT)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class ControllerCenterStub extends io.grpc.stub.AbstractStub<ControllerCenterStub> {
    private ControllerCenterStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ControllerCenterStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ControllerCenterStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ControllerCenterStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void registerService( Service request,
        io.grpc.stub.StreamObserver< Result> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void reportHeartBeat( HeartBeat request,
        io.grpc.stub.StreamObserver< Result> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReportHeartBeatMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class ControllerCenterBlockingStub extends io.grpc.stub.AbstractStub<ControllerCenterBlockingStub> {
    private ControllerCenterBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ControllerCenterBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ControllerCenterBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ControllerCenterBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public  Result registerService( Service request) {
      return blockingUnaryCall(
          getChannel(), getRegisterServiceMethod(), getCallOptions(), request);
    }

    /**
     */
    public  Result reportHeartBeat( HeartBeat request) {
      return blockingUnaryCall(
          getChannel(), getReportHeartBeatMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class ControllerCenterFutureStub extends io.grpc.stub.AbstractStub<ControllerCenterFutureStub> {
    private ControllerCenterFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ControllerCenterFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ControllerCenterFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ControllerCenterFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture< Result> registerService(
         Service request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterServiceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture< Result> reportHeartBeat(
         HeartBeat request) {
      return futureUnaryCall(
          getChannel().newCall(getReportHeartBeatMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_SERVICE = 0;
  private static final int METHODID_REPORT_HEART_BEAT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ControllerCenterImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ControllerCenterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_SERVICE:
          serviceImpl.registerService(( Service) request,
              (io.grpc.stub.StreamObserver< Result>) responseObserver);
          break;
        case METHODID_REPORT_HEART_BEAT:
          serviceImpl.reportHeartBeat(( HeartBeat) request,
              (io.grpc.stub.StreamObserver< Result>) responseObserver);
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

  private static abstract class ControllerCenterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ControllerCenterBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return  DevOpsProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ControllerCenter");
    }
  }

  private static final class ControllerCenterFileDescriptorSupplier
      extends ControllerCenterBaseDescriptorSupplier {
    ControllerCenterFileDescriptorSupplier() {}
  }

  private static final class ControllerCenterMethodDescriptorSupplier
      extends ControllerCenterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ControllerCenterMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ControllerCenterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ControllerCenterFileDescriptorSupplier())
              .addMethod(getRegisterServiceMethod())
              .addMethod(getReportHeartBeatMethod())
              .build();
        }
      }
    }
    return result;
  }
}
