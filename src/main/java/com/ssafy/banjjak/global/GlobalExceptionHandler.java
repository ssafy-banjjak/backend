package com.ssafy.banjjak.global;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseErrorResponse> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new BaseErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "INTERNAL SERVER ERROR"));
    }
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseErrorResponse> handleBaseException(BaseException e) {
        return ResponseEntity.status(e.getStatus()).body(new BaseErrorResponse(e.getStatus(), e.getMessage()));
    }
}
