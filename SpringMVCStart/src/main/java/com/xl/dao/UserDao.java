package com.xl.dao;

import com.xl.domain.Account;
import org.apache.ibatis.annotations.Insert;

public interface UserDao {
    @Insert("insert into tbl_account(name, money) VALUES (#{name}, #{money})")
    void save(Account account);
}
