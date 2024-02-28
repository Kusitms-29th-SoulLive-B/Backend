package com.soullive_b.soullive_be.exception;

import com.soullive_b.soullive_be.exception.dto.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handle(CustomException exception) {
        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(ExceptionResponse.of(exception.getMessage()));
    }
}
