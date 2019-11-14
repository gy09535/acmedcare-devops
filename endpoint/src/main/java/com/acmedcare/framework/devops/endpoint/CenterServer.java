package com.acmedcare.framework.devops.endpoint;

import com.acmedcare.framework.boot.snowflake.EnableSnowflake;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableSnowflake(workerId = "15")
@EnableScheduling
public class CenterServer {

}