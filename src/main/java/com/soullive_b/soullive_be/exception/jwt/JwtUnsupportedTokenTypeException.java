package com.soullive_b.soullive_be.exception.jwt;

import static com.soullive_b.soullive_be.exception.ExceptionContent.UNSUPPORTED_TOKEN_TYPE;

public class JwtUnsupportedTokenTypeException extends JwtException{

    public JwtUnsupportedTokenTypeException() {
        super(UNSUPPORTED_TOKEN_TYPE);
    }
}
