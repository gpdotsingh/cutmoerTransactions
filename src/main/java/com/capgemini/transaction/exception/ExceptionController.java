package com.capgemini.transaction.exception;

import com.capgemini.transaction.enums.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {


    @ExceptionHandler(AccountException.class)
    public ResponseEntity<Object> transactionException(
            AccountException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(ExceptionMessage.EXCEPTION_TIME.name(), LocalDateTime.now());
        body.put(ExceptionMessage.TRANSACTIONEXCEPTIONMSG.name(), ex.getLocalizedMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }



}