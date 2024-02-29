package com.soullive_b.soullive_be.exception.notfound;

import com.soullive_b.soullive_be.exception.ExceptionContent;

import static com.soullive_b.soullive_be.exception.ExceptionContent.UNSUPPORTED_TOKEN_TYPE;

public class JwtUnsupportedTokenTypeException extends JwtException{

    public JwtUnsupportedTokenTypeException() {
        super(UNSUPPORTED_TOKEN_TYPE);
    }
}
