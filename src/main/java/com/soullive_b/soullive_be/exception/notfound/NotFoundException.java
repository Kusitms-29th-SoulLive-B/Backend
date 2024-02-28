package com.soullive_b.soullive_be.exception.notfound;

import com.soullive_b.soullive_be.exception.CustomException;
import com.soullive_b.soullive_be.exception.ExceptionContent;
import org.springframework.http.HttpStatus;

public abstract class NotFoundException extends CustomException {
    public NotFoundException(ExceptionContent exceptionContent) {
        super(HttpStatus.NOT_FOUND, exceptionContent.getMessage());
    }
}
