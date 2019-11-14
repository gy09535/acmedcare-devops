package com.acmedcare.framework.devops.Dto;

import com.acmedcare.framework.devops.QueryBase;
import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
public class CenterServiceQueryDto extends QueryBase {

  @ApiParam("服务名称")
  private String name;
}
