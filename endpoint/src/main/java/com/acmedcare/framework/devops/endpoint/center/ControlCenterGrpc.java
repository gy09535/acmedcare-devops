package com.acmedcare.framework.devops.endpoint.center;


import com.acmedcare.framework.devops.endpoint.center.ControllerCenterGrpc.ControllerCenterImplBase;

public class ControlCenterGrpc extends ControllerCenterImplBase {

  /**
   * <pre>
   * Sends a greeting
   * </pre>
   */
  public void registerService(Service request,
      io.grpc.stub.StreamObserver<Result> responseObserver) {

    Result result = Result.newBuilder()
        .setSuccess(true)
        .setData("").build();
    responseObserver.onNext(result);
    responseObserver.onCompleted();
  }

  /**
   *
   */
  public void reportHeartBeat(HeartBeat request,
      io.grpc.stub.StreamObserver<Result> responseObserver) {

    Result result = Result.newBuilder()
        .setSuccess(true)
        .setData("").build();
    responseObserver.onNext(result);
    responseObserver.onCompleted();
  }
}
