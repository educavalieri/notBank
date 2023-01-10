package com.notBank.services;

import com.notBank.dtos.AccountDto;
import com.notBank.repositories.AccountRepository;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto) throws Exception;

}
