package com.notBank.services.Implements;

import com.notBank.dtos.AccountDto;
import com.notBank.entities.User;
import com.notBank.repositories.AccountRepository;
import com.notBank.services.AccountService;
import com.notBank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class AccoutServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserService userService;

    @Override
    public AccountDto createAccount(AccountDto accountDto, String userEmail) {

        return null;
    }
}
