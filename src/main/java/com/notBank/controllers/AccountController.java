package com.notBank.controllers;

import com.notBank.dtos.AccountDto;
import com.notBank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping
    ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto dto) throws Exception {
        AccountDto response = accountService.createAccount(dto);
        return ResponseEntity.ok().body(response);

    }




}
