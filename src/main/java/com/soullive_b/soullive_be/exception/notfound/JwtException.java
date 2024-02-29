package com.soullive_b.soullive_be.exception.notfound;

import com.soullive_b.soullive_be.exception.CustomException;
import com.soullive_b.soullive_be.exception.ExceptionContent;
import org.springframework.http.HttpStatus;

public class JwtException extends CustomException {

    public JwtException(ExceptionContent exceptionContent) {
        super(HttpStatus.BAD_REQUEST, exceptionContent.getMessage());
    }
}
