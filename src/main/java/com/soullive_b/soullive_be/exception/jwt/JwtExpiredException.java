package com.soullive_b.soullive_be.exception.jwt;

import static com.soullive_b.soullive_be.exception.ExceptionContent.EXPIRED_TOKEN;

public class JwtExpiredException extends JwtException{

    public JwtExpiredException() {
        super(EXPIRED_TOKEN);
    }
}
