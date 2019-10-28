package com.acmedcare.framework.devops.bean;

import com.acmedcare.framework.devops.common.Constants;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * {@link Account} Bean Defined
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 * @version ${project.version} - 2019-03-06.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@TableName("acmedcare_account")
public class Account implements Serializable {

  private static final long serialVersionUID = -6625478147696736439L;

  /** 代理主键 */
  @TableId private long pkid;

  /** 通行证账号 */
  private String passport;

  /** 用户名称 */
  private String username;

  /** 通行证密码 */
  private String password;

  /** 密码加密盐 */
  private String salt;

  /**
   * 账户状态
   *
   * <p>默认: 有效 {@link
   * Constants.AccountStatus#ENABLED}
   *
   * @see Constants.AccountStatus
   */
  private Constants.AccountStatus status = Constants.AccountStatus.ENABLED;

  /** 创建时间 */
  private Date createTime;

  /** 更新时间 */
  private Date upgradeTime;

  /**
   * Default Constructor
   *
   * <p>
   */
  public Account() {}
}
