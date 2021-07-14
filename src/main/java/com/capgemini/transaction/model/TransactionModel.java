package com.capgemini.transaction.model;

import com.capgemini.transaction.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionModel {

    private String id;
    private LocalDateTime time;
    private TransactionType type;
    private BigDecimal amount;
    private String description;
    private String accountNumber;

}
