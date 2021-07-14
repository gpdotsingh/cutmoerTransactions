package com.capgemini.transaction.repository;

import com.capgemini.transaction.entity.TransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TransactionRepo extends JpaRepository<TransactionEntity,Long> {

    Page<TransactionEntity> findAllByAccountNumber(String accountNumber, Pageable pageable);
}
