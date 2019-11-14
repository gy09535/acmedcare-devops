package com.acmedcare.framework.starter.control.rpc;

import com.acmedcare.framework.starter.control.ApplicationContextHelper;
import com.acmedcare.framework.starter.control.protobuf.DevOpsControllerGrpc.DevOpsControllerImplBase;
import com.acmedcare.framework.starter.control.protobuf.RequestDto;
import com.acmedcare.framework.starter.control.protobuf.ResultDto;
import com.acmedcare.framework.starter.control.protobuf.ServiceDto;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;

@SuppressWarnings("unused")
@Slf4j
public class DevOpsControllerImpl extends DevOpsControllerImplBase {

  /**
   *
   */
  @Override
  public void check(RequestDto request,
      io.grpc.stub.StreamObserver<ResultDto> responseObserver) {

    boolean success = false;
    if (ApplicationContextHelper.isAlive()) {
      success = true;
    }

    ResultDto resultDto = ResultDto.newBuilder().setSuccess(success).build();
    responseObserver.onNext(resultDto);
    responseObserver.onCompleted();
  }

  /**
   *
   */
  @Override
  public void start(RequestDto request,
      io.grpc.stub.StreamObserver<ResultDto> responseObserver) {

    ResultDto resultDto = ResultDto.newBuilder().setSuccess(true).build();
    try {

      log.info("正在启动服务");
      ConfigurableApplicationContext applicationContext = ApplicationContextHelper
          .getApplicationContext();
      if (applicationContext != null) {

        applicationContext.start();
      }
    } catch (Throwable e) {

      log.error("启动服务失败:" + e.getMessage(), e);
      resultDto = ResultDto.newBuilder().setSuccess(false).build();
    }

    responseObserver.onNext(resultDto);
    responseObserver.onCompleted();
  }

  /**
   *
   */
  @Override
  public void stop(RequestDto request,
      io.grpc.stub.StreamObserver<ResultDto> responseObserver) {

    ResultDto resultDto = ResultDto.newBuilder().setSuccess(true).build();
    try {
      log.info("正在停止服务");
      ConfigurableApplicationContext applicationContext = ApplicationContextHelper
          .getApplicationContext();
      if (applicationContext != null) {

        applicationContext.stop();
      }
      ApplicationContextHelper.getApplicationContext().stop();
    } catch (Throwable e) {

      resultDto = ResultDto.newBuilder().setSuccess(false).build();
      log.error("停止服务异常:" + e.getMessage(), e);
    }

    responseObserver.onNext(resultDto);
    responseObserver.onCompleted();
  }

  /**
   *
   */
  @Override
  public void getInfo(RequestDto request,
      io.grpc.stub.StreamObserver<ServiceDto> responseObserver) {

    ServiceDto serviceDto = null;
    try {

      ConfigurableApplicationContext applicationContext = ApplicationContextHelper
          .getApplicationContext();
      if (applicationContext != null) {

        serviceDto = ServiceDto.newBuilder()
            .setName(applicationContext.getEnvironment().getProperty("spring.application.name"))
            .setIp(getIp())
            .setPort(applicationContext.getEnvironment().getProperty("local.server.port"))
            .build();
      }
    } catch (Throwable e) {

      log.info("获取服务信息异常:" + e.getMessage(), e);
    }

    responseObserver.onNext(serviceDto);
    responseObserver.onCompleted();
  }

  private String getIp() {

    try {
      InetAddress addr = InetAddress.getByName("mysql.acmedcare.com");
      Socket socket = new Socket(addr, 3306);
      String address = socket.getLocalAddress().toString();
      if (address.contains("/")) {

        address = address.replace("/", "");
      }

      return address;
    } catch (IOException e) {
      e.printStackTrace();
    }

    return "";
  }
}
