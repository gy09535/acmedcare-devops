// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: control_center.proto

package com.acmedcare.framework.devops.endpoint.center;

public interface HeartBeatOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.acmedcare.framework.devops.endpoint.center.HeartBeat)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string serviceName = 1;</code>
   * @return The serviceName.
   */
  String getServiceName();
  /**
   * <code>string serviceName = 1;</code>
   * @return The bytes for serviceName.
   */
  com.google.protobuf.ByteString
      getServiceNameBytes();

  /**
   * <code>int32 successCount = 2;</code>
   * @return The successCount.
   */
  int getSuccessCount();

  /**
   * <code>int32 failCount = 3;</code>
   * @return The failCount.
   */
  int getFailCount();

  /**
   * <code>string ip = 4;</code>
   * @return The ip.
   */
  String getIp();
  /**
   * <code>string ip = 4;</code>
   * @return The bytes for ip.
   */
  com.google.protobuf.ByteString
      getIpBytes();

  /**
   * <code>int64 currentTime = 5;</code>
   * @return The currentTime.
   */
  long getCurrentTime();

  /**
   * <code>string port = 6;</code>
   * @return The port.
   */
  String getPort();
  /**
   * <code>string port = 6;</code>
   * @return The bytes for port.
   */
  com.google.protobuf.ByteString
      getPortBytes();
}
