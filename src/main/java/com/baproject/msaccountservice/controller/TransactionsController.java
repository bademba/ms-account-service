package com.baproject.msaccountservice.controller;

import com.baproject.msaccountservice.entity.Account;
import com.baproject.msaccountservice.entity.Transactions;
import com.baproject.msaccountservice.repository.TransactionsRepository;
import com.baproject.msaccountservice.response.ResponseHandler;
import com.baproject.msaccountservice.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/v1/transactions")
public class TransactionsController {

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private TransactionsService transactionsService;

    Date date = new Date();
    SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String timestamp = DateFor.format(date);

    String methodName = "";

    //create a new account
    @PostMapping("/")
    public ResponseEntity createTransaction(@RequestBody Transactions transactions ){
        methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        //return ResponseEntity.ok(accountService.createAccount(account));
        return ResponseHandler.generateResponse(UUID.randomUUID(),"Transaction created", HttpStatus.CREATED,transactionsService.createAccount(transactions),timestamp);
    }
}
