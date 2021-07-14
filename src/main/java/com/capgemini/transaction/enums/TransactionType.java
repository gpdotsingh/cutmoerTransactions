package com.capgemini.transaction.enums;

public enum TransactionType {

    CREDIT("credit"),
    DEBIT("debit");

    private final String transactionType;

    TransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
