package com.acmedcare.framework.devops.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@Data
@TableName("center_service_heartbeat")
public class CenterHeartbeat {

  @TableId
  private Long heartbeatId;

  @ApiModelProperty("服务名称")
  private String serviceName;

  @ApiModelProperty("成功服务数量")
  private Integer successCount;

  @ApiModelProperty("失败数量")
  private Integer failCount;

  @ApiModelProperty("ip地址")
  private String ip;

  @ApiModelProperty("端口号")
  private String port;

  @ApiModelProperty("创建时间")
  private Date time;
}
