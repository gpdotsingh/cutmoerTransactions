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

    public TransactionModel entityToModelTransaction(TransactionEntity transactionEntity)
    {
        return transactionEntityModelFun.apply(transactionEntity);
    }
    public void insertTestData() {
        //


        TransactionEntity t1 = new TransactionEntity();
        TransactionEntity t2 = new TransactionEntity();
        TransactionEntity t3 = new TransactionEntity();
        TransactionEntity t4 = new TransactionEntity();
        TransactionEntity t5 = new TransactionEntity();
        TransactionEntity t6 = new TransactionEntity();
        TransactionEntity t7 = new TransactionEntity();
        TransactionEntity t8 = new TransactionEntity();


        t1.setAmount(BigDecimal.valueOf(2));
        t2.setAmount(BigDecimal.valueOf(2));
        t3.setAmount(BigDecimal.valueOf(2));
        t4.setAmount(BigDecimal.valueOf(2));
        t5.setAmount(BigDecimal.valueOf(2));
        t6.setAmount(BigDecimal.valueOf(2));
        t7.setAmount(BigDecimal.valueOf(2));
        t8.setAmount(BigDecimal.valueOf(2));

        t1.setTransactionDescription("t1");
        t2.setTransactionDescription("t2");
        t3.setTransactionDescription("t3");
        t4.setTransactionDescription("t4");
        t5.setTransactionDescription("t5");
        t6.setTransactionDescription("t6");
        t7.setTransactionDescription("t7");
        t8.setTransactionDescription("t8");

        t1.setTransactionTime(LocalDateTime.now());
        t2.setTransactionTime(LocalDateTime.now());
        t3.setTransactionTime(LocalDateTime.now());
        t4.setTransactionTime(LocalDateTime.now());
        t5.setTransactionTime(LocalDateTime.now());
        t6.setTransactionTime(LocalDateTime.now());
        t7.setTransactionTime(LocalDateTime.now());
        t8.setTransactionTime(LocalDateTime.now());

        t1.setTransactionType(TransactionType.CREDIT);
        t2.setTransactionType(TransactionType.DEBIT);
        t3.setTransactionType(TransactionType.CREDIT);
        t4.setTransactionType(TransactionType.DEBIT);
        t5.setTransactionType(TransactionType.CREDIT);
        t6.setTransactionType(TransactionType.DEBIT);
        t7.setTransactionType(TransactionType.CREDIT);

        t8.setTransactionType(TransactionType.CREDIT);

        List<TransactionEntity> transactionEntityList1 = new ArrayList<>();
        transactionEntityList1.add(t1);
        transactionEntityList1.add(t2);
        transactionEntityList1.add(t3);
        transactionEntityList1.add(t4);
        transactionEntityList1.add(t5);
        transactionEntityList1.add(t6);

        List<TransactionEntity> transactionEntityList2 = new ArrayList<>();
        transactionEntityList2.add(t7);
        transactionEntityList2.add(t8);



        t1.setTransactionId("t1   t");
        t2.setTransactionId("t2   t");
        t3.setTransactionId("t3   t");
        t4.setTransactionId("t4   t");
        t5.setTransactionId("t5   t");
        t6.setTransactionId("t6   t");
        t7.setTransactionId("t7   t");
        t8.setTransactionId("t8   t");

    }

}
