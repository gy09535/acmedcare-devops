package com.acmedcare.framework.devops.endpoint.service;

import com.acmedcare.framework.devops.bean.Account;
import com.acmedcare.framework.devops.common.exception.BizException;
import com.acmedcare.framework.devops.repository.AccountRepository;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AccountService
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 * @version ${project.version} - 2019-03-06.
 */
@Service
public class AccountService extends ServiceImpl<AccountRepository, Account> {

  private final AccountRepository accountRepository;

  @Autowired
  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  /**
   * Query Account Service
   *
   * @param passport passport
   * @return a instance of {@link Account}
   */
  public Account queryAccount(String passport) throws BizException {
    try {
      QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
      queryWrapper.eq("passport", passport);

      System.out.println("Mapper instance :" + this.baseMapper);
      System.out.println("Repository instance :" + this.accountRepository);

      Account account = this.baseMapper.selectOne(queryWrapper);
      System.out.println("Account-1: " + account.toString());

      account = this.baseMapper.queryAccount(passport);
      System.out.println("Account-2: " + account.toString());

      return this.accountRepository.queryAccount(passport);
    } catch (Exception e) {
      throw new BizException(e);
    }
  }
}
