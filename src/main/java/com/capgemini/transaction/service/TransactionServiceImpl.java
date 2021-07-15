package com.capgemini.transaction.service;

import com.capgemini.transaction.dao.TransactionDao;
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
    TransactionDao transactionDao;

    /***
     *  Create transaction dao and insert data in db
     * @param custId
     * @param transactionTime
     * @param accountNumber
     * @param type
     * @param amount
     * @param description
     * @return
     */
    @Override
    public TransactionModel createTransaction(String custId, LocalDateTime transactionTime, String accountNumber, TransactionType type, BigDecimal amount,String description)
    {
        return transactionDao.createTransaction(custId,accountNumber,transactionTime,type,amount,description);
    }

    /**
     *
     * @param pageSize
     * @param pageNo
     * @param accountNumber
     * @return
     */
    @Override
    public Page<TransactionModel> getTransaction(int pageSize, int pageNo, String accountNumber) {
        return transactionDao.getTransactionPage(pageSize,pageNo,accountNumber);
    }
}




