package com.soullive_b.soullive_be.exception.notfound;

import com.soullive_b.soullive_be.exception.ExceptionContent;

import static com.soullive_b.soullive_be.exception.ExceptionContent.INVALID_TOKEN;

public class JwtInvalidException extends JwtException{

    public JwtInvalidException() {
        super(INVALID_TOKEN);
    }
}
