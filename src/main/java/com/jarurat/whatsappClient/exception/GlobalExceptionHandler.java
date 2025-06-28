package com.jarurat.whatsappClient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralError(Exception e) {
        return new ResponseEntity<>("Something went wrong. Please try again later." + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
