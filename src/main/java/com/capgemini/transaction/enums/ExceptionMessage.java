package com.capgemini.transaction.enums;

public enum ExceptionMessage {


    TRANSACTIONEXCEPTIONMSG("No transaction found for customerId: "),
    EXCEPTION_TIME("Time: ");

    private final String  description;

    ExceptionMessage(String description) {
        this.description = description;
    }
}
