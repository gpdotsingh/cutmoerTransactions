package com.capgemini.transaction.service;

import com.capgemini.transaction.enums.TransactionType;
import com.capgemini.transaction.model.TransactionModel;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface TransactionService {
    TransactionModel createTransaction(String custId, LocalDateTime transactionTime
            , String accountNumber, TransactionType type, BigDecimal amount, String description);
    Page<TransactionModel> getTransaction(int pageSize,int pageNumber,String accountNumber);
}
