package com.xl.service;

import com.xl.domain.Account;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

public interface AccountService {
    void save(Account account);

    void delete(Integer id);

    void update(Account account);

    List<Account> findAll();

    Account findById(Integer id);
    /**
     * 转账操作
     * @param out 转出方
     * @param in 转入方
     * @param money 金额
     */
    @Transactional(rollbackFor = {IOException.class})  //开启事务,IOException默认是不会回滚的
    public void transfer(String out,String in,Double money);
}
