package com.acmedcare.framework.devops;

import io.swagger.annotations.ApiParam;
import java.io.Serializable;
import lombok.Data;

@Data
public class QueryBase implements Serializable {

  @ApiParam(value = "页码,默认1")
  private Integer currPage = 1;

  @ApiParam(value = "条数，默认15")
  private Integer size = 15;
}
