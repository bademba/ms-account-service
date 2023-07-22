package com.baproject.msaccountservice.controller;

import com.baproject.msaccountservice.entity.Account;
import com.baproject.msaccountservice.repository.AccountRepository;
import com.baproject.msaccountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
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

    //activate/deactivate an account
    @PutMapping("/activate")
//    public Optional<> activateAccount(@RequestBody String accountNumber, String status){
//        Optional<Account> account=accountService.getAccount(accountNumber);
//        if(account==null){
//            return new ResponseEntity<>(account,HttpStatus.NOT_FOUND);
//        }
//
//    }
    public ResponseEntity<Account> activateAccount(@RequestBody Account account, String accountNumber, String status){
        Account currentAccount= accountService.findByAccountNumber(accountNumber);
        if(currentAccount==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentAccount.setStatus(account.getStatus());
        Account updatedAccount =accountRepository.save(currentAccount);
        return new ResponseEntity<>(updatedAccount,HttpStatus.OK);
    }
}
