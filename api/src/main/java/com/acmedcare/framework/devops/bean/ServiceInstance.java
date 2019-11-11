package com.acmedcare.framework.devops.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@Data
@TableName("center_service_instance")
public class ServiceInstance {

  @TableId
  private Long instanceId;

  @ApiModelProperty("实例ip地址")
  private String ip;

  @ApiModelProperty("端口号")
  private String port;

  @ApiModelProperty("服务名称")
  private String serviceName;

  @ApiModelProperty("是否存活")
  private boolean alive;

  @ApiModelProperty("最后心跳时间")
  private Date lastHeartTime;

  @ApiModelProperty("实例状态")
  private ServiceInstance.Status status;

  public enum Status {
    Start,
    Stop,
    Restart,
    StartContext,
    StopContext,
  }
}
