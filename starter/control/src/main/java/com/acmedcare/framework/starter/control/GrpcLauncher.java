package com.acmedcare.framework.starter.control;

import com.acmedcare.framework.starter.control.rpc.DevOpsControllerImpl;
import io.grpc.ServerBuilder;
import java.io.IOException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.StringUtils;

@SuppressWarnings("unused")
public class GrpcLauncher {


  public static void startControl(ConfigurableApplicationContext configurableApplicationContext)
      throws IOException {

    ApplicationContextHelper.setApplicationContext(configurableApplicationContext);
    String port = configurableApplicationContext.getEnvironment()
        .getProperty("acmedcare.control.port");

    if (StringUtils.isEmpty(port)) {
      port = "9999";
    }

    ServerBuilder serverBuilder = ServerBuilder.forPort(Integer.parseInt(port));
    serverBuilder.addService(new DevOpsControllerImpl());
    serverBuilder.build().start();
  }
}
