package com.baproject.msaccountservice.entity;

import com.baproject.msaccountservice.utils.AccountNumberGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GeneratorType;
//import org.springframework.data.annotation.Id;

@Entity
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;

    @Column(name = "accountNumber")
    @GeneratorType(type = AccountNumberGenerator.class,when = GenerationTime.INSERT)
    public String accountNumber;

    @Column(name = "accountName")
    public String accountName;

    @Column(name = "currency")
    public String currency;

    @Column(name = "currentBalance")
    public double currentBalance;

    @Column(name = "createdDate")
    @JsonIgnore
    public String createdDate;

    @Column(name = "status")
    public String status;

    public Account(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
//        Date date = new Date();
//        SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        String timestamp = DateFor.format(date);
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
