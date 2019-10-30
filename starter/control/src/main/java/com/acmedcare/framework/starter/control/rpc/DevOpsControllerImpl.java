package com.acmedcare.framework.starter.control.rpc;

import com.acmedcare.framework.starter.control.protobuf.DevOpsControllerGrpc.DevOpsControllerImplBase;
import com.acmedcare.framework.starter.control.protobuf.RequestDto;
import com.acmedcare.framework.starter.control.protobuf.ResultDto;

@SuppressWarnings("unused")
public class DevOpsControllerImpl extends DevOpsControllerImplBase {

  /**
   *
   */
  @Override
  public void check(RequestDto request,
      io.grpc.stub.StreamObserver<ResultDto> responseObserver) {

  }

  /**
   *
   */
  @Override
  public void start(RequestDto request,
      io.grpc.stub.StreamObserver<ResultDto> responseObserver) {
  }

  /**
   *
   */
  @Override
  public void stop(RequestDto request,
      io.grpc.stub.StreamObserver<ResultDto> responseObserver) {
  }

  /**
   *
   */
  @Override
  public void getInfo(RequestDto request,
      io.grpc.stub.StreamObserver<ResultDto> responseObserver) {
  }
}
