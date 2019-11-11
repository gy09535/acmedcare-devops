package com.acmedcare.framework.devops.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@Data
@TableName("center_service")
public class CenterService {

  @TableId
  private Long serviceId;

  @ApiModelProperty("服务名称")
  private String serviceName;

  @ApiModelProperty("创建名称")
  private Date createTime;

  @ApiModelProperty("集群数量")
  private int clusterCount;

  @ApiModelProperty("实例数量")
  private int instanceCount;

  @ApiModelProperty("健康实例数量")
  private int healthInstanceCount;
}
