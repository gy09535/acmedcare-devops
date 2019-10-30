package com.acmedcare.framework.devops;

import com.acmedcare.framework.starter.control.GrpcLauncher;
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
@SpringBootApplication
@EnableDiscoveryClient
public class WebApplicationCloudBootstrap {

  public static void main(String[] args) throws IOException {
    // new application
    ConfigurableApplicationContext configurableApplicationContext = new SpringApplicationBuilder()
        .sources(WebApplicationCloudBootstrap.class)

        // default properties
        .properties("spring.profiles.active=nacos")
        .web(WebApplicationType.SERVLET)
        .run(args);

    GrpcLauncher.startControl(configurableApplicationContext);
  }
}
