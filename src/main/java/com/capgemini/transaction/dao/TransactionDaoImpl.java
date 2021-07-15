package com.capgemini.transaction.dao;

import com.capgemini.transaction.entity.TransactionEntity;
import com.capgemini.transaction.enums.TransactionType;
import com.capgemini.transaction.model.TransactionModel;
import com.capgemini.transaction.repository.TransactionRepo;
import com.capgemini.transaction.util.UtilDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 */
@Component
public class TransactionDaoImpl implements TransactionDao {


    @Autowired
    TransactionRepo transactionRepo;
    @Autowired
    UtilDto utilDto ;

    Page<TransactionEntity> allByAccountId =null;
    Page<TransactionModel> transactionModels = null;

    /**
     *  Fetch data from database and will transform them to transaction model
     * @param pageSize
     * @param pageNo
     * @param accountNumber
     * @return
     */
    public Page<TransactionModel>  getTransactionPage(int pageSize, int pageNo, String accountNumber){

            Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC,"id"));
            allByAccountId = transactionRepo.findAllByAccountNumber(accountNumber, paging);
            // Transaction entity To Model
            transactionModels = utilDto.entityToModelTransactionPage(allByAccountId);
            // Account entity to Model
        return transactionModels;
    }

    /**
     *  Will generate object for new transaction type
     * @param custId
     * @param accountNumber
     * @param transactionTime
     * @param transactionType
     * @param amount
     * @param description
     * @return
     */
    @Override
    public TransactionModel createTransaction(String custId, String accountNumber, LocalDateTime transactionTime, TransactionType transactionType, BigDecimal amount,String description) {

        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAccountNumber(accountNumber);
        transactionEntity.setTransactionType(transactionType);
        transactionEntity.setTransactionId(null);
        transactionEntity.setTransactionTime(transactionTime);
        transactionEntity.setTransactionDescription(description);
        transactionEntity.setAmount(amount);
        TransactionEntity updatedTransaction = transactionRepo.save(transactionEntity);
        return utilDto.entityToModelTransaction(updatedTransaction);
    }
}
