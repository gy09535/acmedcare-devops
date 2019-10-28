package com.acmedcare.framework.devops.repository;

import com.acmedcare.framework.devops.bean.Account;
import com.acmedcare.framework.devops.common.exception.RepositoryException;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * {@link AccountRepository} Methods Defined
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 * @version ${project.version} - 2019-03-06.
 */
@SuppressWarnings("unused")
public interface AccountRepository extends BaseMapper<Account> {

  /**
   * Query {@link Account} by passport
   *
   * @param passport passport
   * @return a instance of {@link Account}
   * @throws RepositoryException repository exception
   */
  Account queryAccount(String passport) throws RepositoryException;
}
