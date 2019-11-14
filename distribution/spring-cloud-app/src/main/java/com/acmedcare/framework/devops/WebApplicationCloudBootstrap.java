package com.acmedcare.framework.devops;

import com.acmedcare.framework.boot.snowflake.EnableSnowflake;
import com.acmedcare.framework.devops.endpoint.CenterServer;
import com.acmedcare.framework.devops.endpoint.center.ControlCenterGrpc;
import com.acmedcare.framework.starter.control.GrpcLauncher;
import io.grpc.ServerBuilder;
import java.io.IOException;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import xyz.vopen.tiffany.swagger.EnableSwagger2;

/**
 * {@link WebApplicationCloudBootstrap}
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 * @version ${project.version} - 2019-03-12.
 */
@EnableSwagger2
@SpringBootApplication(scanBasePackageClasses = CenterServer.class)
@EnableDiscoveryClient
public class WebApplicationCloudBootstrap extends CenterServer {

  public static void main(String[] args) throws IOException {
    // new application
    ConfigurableApplicationContext configurableApplicationContext = new SpringApplicationBuilder()
        .sources(WebApplicationCloudBootstrap.class)

        // default properties
        .properties("spring.profiles.active=nacos")
        .web(WebApplicationType.SERVLET)
        .run(args);

    ServerBuilder serverBuilder = ServerBuilder.forPort(9998);
    serverBuilder.addService(configurableApplicationContext.getBean(ControlCenterGrpc.class));
    serverBuilder.build().start();
    GrpcLauncher.startControl(configurableApplicationContext);
  }
}
