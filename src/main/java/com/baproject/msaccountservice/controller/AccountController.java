package com.baproject.msaccountservice.controller;

import com.baproject.msaccountservice.entity.Account;
import com.baproject.msaccountservice.repository.AccountRepository;
import com.baproject.msaccountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.locks.ReadWriteLock;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    //create a new account
    @PostMapping("/")
    public ResponseEntity createAccount(@RequestBody Account account){
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    //list accounts
    @GetMapping("/")
    public ResponseEntity<Object> listAccounts(){
        return ResponseEntity.ok(accountService.listAccounts());
    }
}
