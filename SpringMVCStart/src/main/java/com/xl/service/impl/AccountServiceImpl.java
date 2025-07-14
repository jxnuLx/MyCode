package com.xl.service.impl;


import com.xl.domain.Account;
import com.xl.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {


    public void save(Account account) {
        System.out.println("save account service...");
    }

}
