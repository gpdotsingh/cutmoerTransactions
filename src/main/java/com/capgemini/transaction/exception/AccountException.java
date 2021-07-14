package com.capgemini.transaction.exception;

public class AccountException extends RuntimeException {
    public AccountException(String exception) {
        super(String.format("%s ",exception));
    }
}
