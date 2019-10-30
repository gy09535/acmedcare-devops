package com.acmedcare.framework.starter.control;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnControlEnabled
public class ControlAutoConfiguration {


  @Bean
  public ApplicationContextHelper applicationContextHelper() {

    return new ApplicationContextHelper();
  }

  public static interface ServiceDtoOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.acmedcare.framework.starter.control.protobuf.ServiceDto)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string name = 1;</code>
     * @return The name.
     */
    String getName();
    /**
     * <code>string name = 1;</code>
     * @return The bytes for name.
     */
    com.google.protobuf.ByteString
        getNameBytes();

    /**
     * <code>string ip = 2;</code>
     * @return The ip.
     */
    String getIp();
    /**
     * <code>string ip = 2;</code>
     * @return The bytes for ip.
     */
    com.google.protobuf.ByteString
        getIpBytes();

    /**
     * <code>string por = 3;</code>
     * @return The por.
     */
    String getPor();
    /**
     * <code>string por = 3;</code>
     * @return The bytes for por.
     */
    com.google.protobuf.ByteString
        getPorBytes();
  }
}