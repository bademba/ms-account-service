package com.baproject.msaccountservice.service;

import com.baproject.msaccountservice.entity.Account;
import com.baproject.msaccountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    public Account createAccount(Account account){
        return accountRepository.save(account);
    }
}
