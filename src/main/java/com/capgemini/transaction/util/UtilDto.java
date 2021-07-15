package com.capgemini.transaction.util;

import com.capgemini.transaction.entity.TransactionEntity;
import com.capgemini.transaction.enums.TransactionType;
import com.capgemini.transaction.model.TransactionModel;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class UtilDto {

    /**
     * Responsible for converting page from TransactionEntity entity to TransactionModel
     * @param allByAccountId
     * @return
     */
    public Page<TransactionModel> entityToModelTransactionPage(Page<TransactionEntity> allByAccountId) {
        return allByAccountId
                .map(transactionEntity ->
                 transactionEntityModelFun.apply(transactionEntity));
    }

    Function<TransactionEntity, TransactionModel> transactionEntityModelFun = transactionEntityToModel -> {
        String transactionId = transactionEntityToModel.getTransactionId();
        LocalDateTime transactionTime = transactionEntityToModel.getTransactionTime();
        TransactionType transactionType = transactionEntityToModel.getTransactionType();
        BigDecimal amount = transactionEntityToModel.getAmount();
        String transactionDescription = transactionEntityToModel.getTransactionDescription();
        String accountNumber = transactionEntityToModel.getAccountNumber();
        return new TransactionModel(transactionId, transactionTime, transactionType, amount, transactionDescription, accountNumber);
    };

    /**
     *
     * @param transactionEntity
     * @return
     */
    public TransactionModel entityToModelTransaction(TransactionEntity transactionEntity)
    {
        return transactionEntityModelFun.apply(transactionEntity);
    }

}
