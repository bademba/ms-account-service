package com.baproject.msaccountservice.service;

import com.baproject.msaccountservice.entity.Account;
import com.baproject.msaccountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

    public List<Account> listAccounts(){
        return accountRepository.findAll();
    }

    public Account findByAccountNumber(String accountNumber){
        return accountRepository.findByAccountNumber(accountNumber);
    }

    public Account deposit(String accountNumber,double amount){
        Account account = findByAccountNumber(accountNumber);
//        Account account =findByAccountNumber(accountNumber).orElseThrow(()-> {
//            return new RuntimeException("Account not found");
//        });
        if(account ==null){
            throw new RuntimeException("Account not found");
        }
        account.setCurrentBalance(account.getCurrentBalance()+amount);
        return accountRepository.save(account);
    }
}
