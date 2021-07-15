package com.capgemini.transaction.controller;

import com.capgemini.transaction.enums.TransactionType;
import com.capgemini.transaction.model.TransactionModel;
import com.capgemini.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    /**
     * Will create the transaction in database against account number
     * @param transactionTime
     * @param amount
     * @param custId
     * @param accountNumber
     * @param description
     * @param transactionType
     * @return
     */
    @PostMapping("{transactionType}")
    public TransactionModel transactions( @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime transactionTime,@RequestParam BigDecimal amount, @RequestParam String custId, @RequestParam String accountNumber, @RequestParam String description,@PathVariable TransactionType transactionType)
    {
        return transactionService.createTransaction(custId,transactionTime,accountNumber,transactionType,amount,description);
    }

    /**
     *Will get the transaction on by accepting account number
     * @param pageNo
     * @param pageSize
     * @param accountNumber
     * @return
     */
    @GetMapping
    public Page<TransactionModel> transactions(@RequestParam int pageNo, @RequestParam int pageSize, @RequestParam String accountNumber)
    {
        return transactionService.getTransaction(pageSize,pageNo,accountNumber);
    }
}
