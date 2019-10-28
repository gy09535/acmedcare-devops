package com.acmedcare.framework.devops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.vopen.tiffany.swagger.EnableSwagger2;

/**
 * {@link TemplateApplicationBootstrap}
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 * @version ${project.version} - 2019-03-12.
 */
@EnableSwagger2
@SpringBootApplication
public class TemplateApplicationBootstrap {

  public static void main(String[] args) {
    SpringApplication.run(TemplateApplicationBootstrap.class, args);
  }
}
