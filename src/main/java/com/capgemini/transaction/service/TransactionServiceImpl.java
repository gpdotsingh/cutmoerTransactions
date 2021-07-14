package com.capgemini.transaction.service;

import com.capgemini.transaction.dao.AccountDao;
import com.capgemini.transaction.enums.TransactionType;
import com.capgemini.transaction.model.TransactionModel;
import com.capgemini.transaction.util.UtilDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    UtilDto utilDto ;
    @Autowired
    AccountDao accountDao;

    @Override
    public TransactionModel createTransaction(String custId, LocalDateTime transactionTime, String accountNumber, TransactionType type, BigDecimal amount,String description)
    {
        return accountDao.createTransaction(custId,accountNumber,transactionTime,type,amount,description);
    }

    @Override
    public Page<TransactionModel> getTransaction(int pageSize, int pageNo, String accountNumber) {
        return accountDao.getTransactionPage(pageSize,pageNo,accountNumber);
    }
}




