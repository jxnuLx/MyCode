package com.xl.service;

import com.xl.domain.Account;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

public interface AccountService {
    void save(Account account);
}
