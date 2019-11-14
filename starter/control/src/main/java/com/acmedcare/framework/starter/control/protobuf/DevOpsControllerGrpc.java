package com.acmedcare.framework.starter.control.protobuf;

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
 * <pre>
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.24.0)",
    comments = "Source: controller.proto")
public final class DevOpsControllerGrpc {

  private DevOpsControllerGrpc() {}

  public static final String SERVICE_NAME = "com.acmedcare.framework.starter.control.protobuf.DevOpsController";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<RequestDto,
      ResultDto> getCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "check",
      requestType = RequestDto.class,
      responseType = ResultDto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RequestDto,
      ResultDto> getCheckMethod() {
    io.grpc.MethodDescriptor<RequestDto, ResultDto> getCheckMethod;
    if ((getCheckMethod = DevOpsControllerGrpc.getCheckMethod) == null) {
      synchronized (DevOpsControllerGrpc.class) {
        if ((getCheckMethod = DevOpsControllerGrpc.getCheckMethod) == null) {
          DevOpsControllerGrpc.getCheckMethod = getCheckMethod =
              io.grpc.MethodDescriptor.<RequestDto, ResultDto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "check"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RequestDto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ResultDto.getDefaultInstance()))
              .setSchemaDescriptor(new DevOpsControllerMethodDescriptorSupplier("check"))
              .build();
        }
      }
    }
    return getCheckMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RequestDto,
      ResultDto> getStartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "start",
      requestType = RequestDto.class,
      responseType = ResultDto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RequestDto,
      ResultDto> getStartMethod() {
    io.grpc.MethodDescriptor<RequestDto, ResultDto> getStartMethod;
    if ((getStartMethod = DevOpsControllerGrpc.getStartMethod) == null) {
      synchronized (DevOpsControllerGrpc.class) {
        if ((getStartMethod = DevOpsControllerGrpc.getStartMethod) == null) {
          DevOpsControllerGrpc.getStartMethod = getStartMethod =
              io.grpc.MethodDescriptor.<RequestDto, ResultDto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "start"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RequestDto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ResultDto.getDefaultInstance()))
              .setSchemaDescriptor(new DevOpsControllerMethodDescriptorSupplier("start"))
              .build();
        }
      }
    }
    return getStartMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RequestDto,
      ResultDto> getStopMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "stop",
      requestType = RequestDto.class,
      responseType = ResultDto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RequestDto,
      ResultDto> getStopMethod() {
    io.grpc.MethodDescriptor<RequestDto, ResultDto> getStopMethod;
    if ((getStopMethod = DevOpsControllerGrpc.getStopMethod) == null) {
      synchronized (DevOpsControllerGrpc.class) {
        if ((getStopMethod = DevOpsControllerGrpc.getStopMethod) == null) {
          DevOpsControllerGrpc.getStopMethod = getStopMethod =
              io.grpc.MethodDescriptor.<RequestDto, ResultDto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "stop"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RequestDto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ResultDto.getDefaultInstance()))
              .setSchemaDescriptor(new DevOpsControllerMethodDescriptorSupplier("stop"))
              .build();
        }
      }
    }
    return getStopMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RequestDto,
      ServiceDto> getGetInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getInfo",
      requestType = RequestDto.class,
      responseType = ServiceDto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RequestDto,
      ServiceDto> getGetInfoMethod() {
    io.grpc.MethodDescriptor<RequestDto, ServiceDto> getGetInfoMethod;
    if ((getGetInfoMethod = DevOpsControllerGrpc.getGetInfoMethod) == null) {
      synchronized (DevOpsControllerGrpc.class) {
        if ((getGetInfoMethod = DevOpsControllerGrpc.getGetInfoMethod) == null) {
          DevOpsControllerGrpc.getGetInfoMethod = getGetInfoMethod =
              io.grpc.MethodDescriptor.<RequestDto, ServiceDto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RequestDto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ServiceDto.getDefaultInstance()))
              .setSchemaDescriptor(new DevOpsControllerMethodDescriptorSupplier("getInfo"))
              .build();
        }
      }
    }
    return getGetInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DevOpsControllerStub newStub(io.grpc.Channel channel) {
    return new DevOpsControllerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DevOpsControllerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DevOpsControllerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DevOpsControllerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DevOpsControllerFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class DevOpsControllerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void check(RequestDto request,
        io.grpc.stub.StreamObserver<ResultDto> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckMethod(), responseObserver);
    }

    /**
     */
    public void start(RequestDto request,
        io.grpc.stub.StreamObserver<ResultDto> responseObserver) {
      asyncUnimplementedUnaryCall(getStartMethod(), responseObserver);
    }

    /**
     */
    public void stop(RequestDto request,
        io.grpc.stub.StreamObserver<ResultDto> responseObserver) {
      asyncUnimplementedUnaryCall(getStopMethod(), responseObserver);
    }

    /**
     */
    public void getInfo(RequestDto request,
        io.grpc.stub.StreamObserver<ServiceDto> responseObserver) {
      asyncUnimplementedUnaryCall(getGetInfoMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                RequestDto,
                ResultDto>(
                  this, METHODID_CHECK)))
          .addMethod(
            getStartMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                RequestDto,
                ResultDto>(
                  this, METHODID_START)))
          .addMethod(
            getStopMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                RequestDto,
                ResultDto>(
                  this, METHODID_STOP)))
          .addMethod(
            getGetInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                RequestDto,
                ServiceDto>(
                  this, METHODID_GET_INFO)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class DevOpsControllerStub extends io.grpc.stub.AbstractStub<DevOpsControllerStub> {
    private DevOpsControllerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DevOpsControllerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected DevOpsControllerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DevOpsControllerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void check(RequestDto request,
        io.grpc.stub.StreamObserver<ResultDto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void start(RequestDto request,
        io.grpc.stub.StreamObserver<ResultDto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStartMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void stop(RequestDto request,
        io.grpc.stub.StreamObserver<ResultDto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStopMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getInfo(RequestDto request,
        io.grpc.stub.StreamObserver<ServiceDto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class DevOpsControllerBlockingStub extends io.grpc.stub.AbstractStub<DevOpsControllerBlockingStub> {
    private DevOpsControllerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DevOpsControllerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected DevOpsControllerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DevOpsControllerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public ResultDto check(RequestDto request) {
      return blockingUnaryCall(
          getChannel(), getCheckMethod(), getCallOptions(), request);
    }

    /**
     */
    public ResultDto start(RequestDto request) {
      return blockingUnaryCall(
          getChannel(), getStartMethod(), getCallOptions(), request);
    }

    /**
     */
    public ResultDto stop(RequestDto request) {
      return blockingUnaryCall(
          getChannel(), getStopMethod(), getCallOptions(), request);
    }

    /**
     */
    public ServiceDto getInfo(RequestDto request) {
      return blockingUnaryCall(
          getChannel(), getGetInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class DevOpsControllerFutureStub extends io.grpc.stub.AbstractStub<DevOpsControllerFutureStub> {
    private DevOpsControllerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DevOpsControllerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected DevOpsControllerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DevOpsControllerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ResultDto> check(
        RequestDto request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ResultDto> start(
        RequestDto request) {
      return futureUnaryCall(
          getChannel().newCall(getStartMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ResultDto> stop(
        RequestDto request) {
      return futureUnaryCall(
          getChannel().newCall(getStopMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ServiceDto> getInfo(
        RequestDto request) {
      return futureUnaryCall(
          getChannel().newCall(getGetInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK = 0;
  private static final int METHODID_START = 1;
  private static final int METHODID_STOP = 2;
  private static final int METHODID_GET_INFO = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DevOpsControllerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DevOpsControllerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK:
          serviceImpl.check((RequestDto) request,
              (io.grpc.stub.StreamObserver<ResultDto>) responseObserver);
          break;
        case METHODID_START:
          serviceImpl.start((RequestDto) request,
              (io.grpc.stub.StreamObserver<ResultDto>) responseObserver);
          break;
        case METHODID_STOP:
          serviceImpl.stop((RequestDto) request,
              (io.grpc.stub.StreamObserver<ResultDto>) responseObserver);
          break;
        case METHODID_GET_INFO:
          serviceImpl.getInfo((RequestDto) request,
              (io.grpc.stub.StreamObserver<ServiceDto>) responseObserver);
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

  private static abstract class DevOpsControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DevOpsControllerBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return DevOpsProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DevOpsController");
    }
  }

  private static final class DevOpsControllerFileDescriptorSupplier
      extends DevOpsControllerBaseDescriptorSupplier {
    DevOpsControllerFileDescriptorSupplier() {}
  }

  private static final class DevOpsControllerMethodDescriptorSupplier
      extends DevOpsControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DevOpsControllerMethodDescriptorSupplier(String methodName) {
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
      synchronized (DevOpsControllerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DevOpsControllerFileDescriptorSupplier())
              .addMethod(getCheckMethod())
              .addMethod(getStartMethod())
              .addMethod(getStopMethod())
              .addMethod(getGetInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
