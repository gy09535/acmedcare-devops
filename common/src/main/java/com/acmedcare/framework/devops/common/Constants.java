package com.acmedcare.framework.devops.common;

/**
 * {@link Constants} Defined
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 * @version ${project.version} - 2019-03-06.
 */
@SuppressWarnings("unused")
public final class Constants {

  /**
   * {@link AccountStatus} defined
   *
   * @since ${project.version}
   */
  public static enum AccountStatus {

    /** 有效账户状态 */
    ENABLED,

    /** 账户锁定状态 */
    LOCKED,

    /** 无效账户(注销状态) */
    DISABLED,
  }
}
