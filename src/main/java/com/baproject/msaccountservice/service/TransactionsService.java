package com.baproject.msaccountservice.service;

import com.baproject.msaccountservice.entity.Transactions;
import com.baproject.msaccountservice.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionsService {
    @Autowired
    private TransactionsRepository transactionsRepository;

    public Transactions createAccount(Transactions transactions){
        return transactionsRepository.save(transactions);
    }
}
