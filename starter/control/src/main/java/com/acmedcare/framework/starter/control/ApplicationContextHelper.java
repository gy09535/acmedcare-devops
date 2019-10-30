package com.acmedcare.framework.starter.control;

import org.springframework.context.ConfigurableApplicationContext;

public class ApplicationContextHelper {


  private static ConfigurableApplicationContext applicationContext;


  public static boolean isAlive() {

    if (applicationContext == null) {

      return false;
    }

    return applicationContext.isRunning();
  }

  public static ConfigurableApplicationContext getApplicationContext() {
    return applicationContext;
  }

  public static void setApplicationContext(
      ConfigurableApplicationContext applicationContext) {
    ApplicationContextHelper.applicationContext = applicationContext;
  }
}
