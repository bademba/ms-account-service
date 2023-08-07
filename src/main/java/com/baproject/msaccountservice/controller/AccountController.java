package com.baproject.msaccountservice.controller;

import com.baproject.msaccountservice.entity.Account;
import com.baproject.msaccountservice.repository.AccountRepository;
import com.baproject.msaccountservice.response.ResponseHandler;
import com.baproject.msaccountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    Date date = new Date();
    SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String timestamp = DateFor.format(date);

    //create a new account
    @PostMapping("/")
    public ResponseEntity createAccount(@RequestBody Account account){
        //return ResponseEntity.ok(accountService.createAccount(account));
        return ResponseHandler.generateResponse(UUID.randomUUID(),"Account created",HttpStatus.CREATED,accountService.createAccount(account),timestamp);
    }

    //list accounts
    @GetMapping("/")
    public ResponseEntity<Object> listAccounts(){
       // return ResponseEntity.ok(accountService.listAccounts());
        return ResponseHandler.generateResponse(UUID.randomUUID(),"Accounts retrieved",HttpStatus.OK,accountService.listAccounts(),timestamp);
    }

    //activate/deactivate an account
    @PutMapping("/{accountNumber}")
    public ResponseEntity<Object> activateAccount(@RequestBody Account account, @PathVariable  String accountNumber){

        Account currentAccount= accountService.findByAccountNumber(accountNumber);
        if(currentAccount==null){
            return ResponseHandler.generateResponse(UUID.randomUUID(),"Account not found",HttpStatus.NOT_FOUND,"",timestamp);
        }
        currentAccount.setStatus(account.getStatus());
        Account updatedAccount =accountRepository.save(currentAccount);
        //return new ResponseEntity<>(updatedAccount,HttpStatus.OK);
        return ResponseHandler.generateResponse(UUID.randomUUID(),"Account updated",HttpStatus.OK,updatedAccount,timestamp);
    }
}
