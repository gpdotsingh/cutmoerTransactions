package com.capgemini.transaction.dao;

import com.capgemini.transaction.enums.TransactionType;
import com.capgemini.transaction.model.TransactionModel;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface TransactionDao {

    Page<TransactionModel> getTransactionPage(int pageSize, int pageNo, String accountNumber);
    TransactionModel createTransaction(String custId, String accountNumber
            , LocalDateTime transactionTime, TransactionType transactionType, BigDecimal amount,String description);

}
