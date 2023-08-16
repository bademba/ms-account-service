package com.baproject.msaccountservice.controller;

import com.baproject.msaccountservice.entity.Account;
import com.baproject.msaccountservice.entity.Transactions;
import com.baproject.msaccountservice.repository.AccountRepository;
import com.baproject.msaccountservice.response.ResponseHandler;
import com.baproject.msaccountservice.service.AccountService;
import com.baproject.msaccountservice.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    TransactionsService transactionsService;


    RestTemplate restTemplate = new RestTemplate();

    Date date = new Date();
    SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String timestamp = DateFor.format(date);

    String methodName = "";

    //create a new account
    @PostMapping("/")
    public ResponseEntity createAccount(@RequestBody Account account){
        methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        //return ResponseEntity.ok(accountService.createAccount(account));
        return ResponseHandler.generateResponse(UUID.randomUUID(),"Account created",HttpStatus.CREATED,accountService.createAccount(account),timestamp);
    }

    //list accounts
    @GetMapping("/")
    public ResponseEntity<Object> listAccounts(){
       // return ResponseEntity.ok(accountService.listAccounts());
        return ResponseHandler.generateResponse(UUID.randomUUID(),"Accounts retrieved",HttpStatus.OK,accountService.listAccounts(),timestamp);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Object> findAccount(@PathVariable String accountNumber){
        Account currentAccount= accountService.findByAccountNumber(accountNumber);
        if(currentAccount==null){
            return ResponseHandler.generateResponse(UUID.randomUUID(),"Account not found",HttpStatus.NOT_FOUND,"",timestamp);
        }
        return ResponseHandler.generateResponse(UUID.randomUUID(),"Account details found",HttpStatus.OK,currentAccount,timestamp);
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

    @PostMapping("/deposit/{accountNumber}")
    public ResponseEntity<Object> deposit(@PathVariable String accountNumber, @RequestBody Map<String ,Double> request){
        Account currentAccount= accountService.findByAccountNumber(accountNumber);
        if(currentAccount==null){
            return ResponseHandler.generateResponse(UUID.randomUUID(),"Account not found",HttpStatus.NOT_FOUND,"",timestamp);
        }
        Double amount =request.get("amount");
        //
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TransactionsService> requestBody = new HttpEntity<>(transactionsService, headers);
        String transactionUrl= "http://localhost:9193/v1/transactions/";
       Transactions tx=restTemplate.postForObject(transactionUrl,requestBody,Transactions.class);
        //
        return ResponseHandler.generateResponse(UUID.randomUUID(),"Deposit successful",HttpStatus.OK,accountService.deposit(accountNumber,amount),timestamp);
    }

    @PostMapping("/withdraw/{accountNumber}")
    public ResponseEntity<Object> withdraw(@PathVariable String accountNumber, @RequestBody Map<String ,Double> request){
        Account currentAccount= accountService.findByAccountNumber(accountNumber);
        if(currentAccount==null){
            return ResponseHandler.generateResponse(UUID.randomUUID(),"Account not found",HttpStatus.NOT_FOUND,"",timestamp);
        }
        Double amount =request.get("amount");
        return ResponseHandler.generateResponse(UUID.randomUUID(),"Withdrawal successful",HttpStatus.OK,accountService.withdraw(accountNumber,amount),timestamp);
    }
}
