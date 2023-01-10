package com.notBank.services.Implements;

import com.notBank.dtos.AccountDto;
import com.notBank.entities.Account;
import com.notBank.entities.User;
import com.notBank.repositories.AccountRepository;
import com.notBank.repositories.UserRepository;
import com.notBank.services.AccountService;
import com.notBank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccoutServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;


    @Override
    public AccountDto createAccount(AccountDto accountDto) throws Exception {

        Account account = Account
                .builder()
                .userType(accountDto.getUserType())
                .type(accountDto.getType())
                .amount(accountDto.getAmount())
                .build();
        account = accountRepository.save(account);

        User user = userRepository.findById(accountDto.getUserId()).get();
        user.setAccount(account);
        user = userRepository.save(user);

        return AccountDto
                .builder()
                .userId(user.getId())
                .amount(account.getAmount())
                .type(account.getType())
                .userType(account.getUserType())
                .build();
    }
}
