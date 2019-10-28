package com.acmedcare.framework.devops.repository.mybatis.handler;

import com.acmedcare.framework.devops.common.Constants;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * {@link AccountStatusTypeHandler}
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 * @version ${project.version} - 2019-03-12.
 */
public class AccountStatusTypeHandler extends BaseTypeHandler<Constants.AccountStatus> {
  @Override
  public void setNonNullParameter(
      PreparedStatement ps, int i, Constants.AccountStatus parameter, JdbcType jdbcType)
      throws SQLException {

  }

  @Override
  public Constants.AccountStatus getNullableResult(ResultSet rs, String columnName)
      throws SQLException {
    return null;
  }

  @Override
  public Constants.AccountStatus getNullableResult(ResultSet rs, int columnIndex)
      throws SQLException {
    return null;
  }

  @Override
  public Constants.AccountStatus getNullableResult(CallableStatement cs, int columnIndex)
      throws SQLException {
    return null;
  }
}
