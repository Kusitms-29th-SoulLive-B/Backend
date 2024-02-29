package com.soullive_b.soullive_be.exception.jwt;

import static com.soullive_b.soullive_be.exception.ExceptionContent.INVALID_TOKEN;

public class JwtInvalidException extends JwtException{

    public JwtInvalidException() {
        super(INVALID_TOKEN);
    }
}
