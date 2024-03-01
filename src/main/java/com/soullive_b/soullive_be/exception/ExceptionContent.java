package com.soullive_b.soullive_be.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionContent {
    /**
     * 유저 관련 에러 : 2000
     */
    NOT_FOUND_USER("유저가 존재하지 않습니다.",2001),

    /**
     * 토큰 관련 에러 : 3000
     */
    INVALID_TOKEN("유효하지 않은 토큰 입니다.", 3001),
    EXPIRED_TOKEN("만료된 토큰 입니다.", 3002),
    UNSUPPORTED_TOKEN_TYPE("지원되지 않는 토큰형식입니다.", 3003),

    /**
     * 회원가입 관련 에러 : 4000
     */
    NULL_INFORMATION("빈 값이 존재합니다", 4001),
    NOT_EMAIL("이메일 형식을 만족하지 않습니다", 4002);

    private final String message;
    private final Integer code;
}
