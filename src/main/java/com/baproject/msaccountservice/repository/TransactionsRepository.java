package com.baproject.msaccountservice.repository;

import com.baproject.msaccountservice.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions,String> {
}
