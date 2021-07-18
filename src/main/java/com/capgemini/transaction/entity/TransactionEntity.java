package com.capgemini.transaction.entity;

import com.capgemini.transaction.enums.TransactionType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "Transaction_Entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column( unique=true,nullable = false,length=100)
    private String transactionId;
    @Column( nullable = false)
    private LocalDateTime transactionTime;
    @Column( nullable = false)
    private TransactionType transactionType;
    @Column( nullable = false)
    private BigDecimal amount;
    @Column(name = "TRANSACTION_DESCRIPTION", nullable = false)
    private String transactionDescription;
    @Column(name = "ACCOUNT_NUMBER", nullable = false)
    private String accountNumber;


    public void setTransactionId() {
        this.transactionId = this.transactionType.name()+LocalDateTime.now()+this.accountNumber;
    }
}
