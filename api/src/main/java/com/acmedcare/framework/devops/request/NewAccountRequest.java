package com.acmedcare.framework.devops.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * {@link NewAccountRequest}
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 * @version ${project.version} - 2019-04-01.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@ApiModel(description = "创建通行证请求对象")
public class NewAccountRequest implements Serializable {

  private static final long serialVersionUID = -2696675967909648374L;

  /**
   * Account Name (passport)
   *
   * <p>
   */
  @NotBlank(message = "通行证账号不能为空")
  @ApiModelProperty(required = true, value = "通行证账号")
  private String accountName;

  /**
   * Account Passport (RSA)
   *
   * <p>
   */
  @NotBlank(message = "通行证密码不能为空")
  @ApiModelProperty(required = true, value = "通行证密码(RSA)")
  private String accountPassword;

  /**
   * Default Constructor of {@link NewAccountRequest}
   *
   * <p>
   */
  public NewAccountRequest() {}
}
