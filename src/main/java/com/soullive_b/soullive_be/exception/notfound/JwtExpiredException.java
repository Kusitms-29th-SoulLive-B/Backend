package com.soullive_b.soullive_be.exception.notfound;

import com.soullive_b.soullive_be.exception.ExceptionContent;

import static com.soullive_b.soullive_be.exception.ExceptionContent.EXPIRED_TOKEN;

public class JwtExpiredException extends JwtException{

    public JwtExpiredException() {
        super(EXPIRED_TOKEN);
    }
}
