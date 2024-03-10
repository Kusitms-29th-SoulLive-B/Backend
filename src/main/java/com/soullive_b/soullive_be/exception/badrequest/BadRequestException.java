package com.soullive_b.soullive_be.exception.badrequest;

import com.soullive_b.soullive_be.exception.CustomException;
import com.soullive_b.soullive_be.exception.ExceptionContent;
import org.springframework.http.HttpStatus;

public class BadRequestException extends CustomException {
    public BadRequestException(ExceptionContent exceptionContent) {
        super(HttpStatus.BAD_REQUEST, exceptionContent);
    };
}
