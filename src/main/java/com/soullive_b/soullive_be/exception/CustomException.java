package com.soullive_b.soullive_be.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public abstract class CustomException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final ExceptionContent content;
}
