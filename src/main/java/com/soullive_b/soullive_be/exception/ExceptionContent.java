package com.soullive_b.soullive_be.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionContent {
    NOT_FOUND_USER("유저가 존재하지 않습니다."),

    INVALID_TOKEN("유효하지 않은 토큰 입니다."),
    EXPIRED_TOKEN("만료된 토큰 입니다."),
    UNSUPPORTED_TOKEN_TYPE("지원되지 않는 토큰형식입니다.");

    private final String message;
}
