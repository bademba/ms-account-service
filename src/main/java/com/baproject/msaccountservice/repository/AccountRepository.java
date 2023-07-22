package com.baproject.msaccountservice.repository;

import com.baproject.msaccountservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {
    Account findByAccountNumber(String accountNumber);
}
