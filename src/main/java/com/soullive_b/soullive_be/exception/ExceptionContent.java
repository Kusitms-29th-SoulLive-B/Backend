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
     * 모델 관련 에러 : 4000
     */
    NOT_FOUND_MODEL("모델이 존재하지 않습니다.", 4001),

    /**
     * 회원가입 관련 에러 : 5000
     */
    NULL_INFORMATION("빈 값이 존재합니다", 5001),
    NOT_EMAIL("이메일 형식을 만족하지 않습니다", 5002),

    /**
     * 모델 선호 계층 관련 에러 : 6000
     */
    NOT_FOUND_POPULARITY("모델의 선호 계층이 존재하지 않습니다.",6001),

    /**
     * 키워드 관련 에러 : 7000
     */
    NOT_FOUND_KEYWORD("키워드가 존재하지 않습니다.",7001),

    /**
     * 기업 분류 관련 에러 : 8000
     */
    NOT_FOUND_ENTERPRISE_TYPE("기업 분류가 존재하지 않습니다.", 8001),

    /**
     * S3 관련 에러 : 9000
     */
    NOT_FOUND_S3("사진 업로드 혹은 삭제에 실패하였습니다", 9001),

    /**
     * 유저모델 관련 에러 : 10000
     */
    BAD_REQUEST_SELECT("이미 존재하는 스크랩입니다.", 10001),
    NOT_FOUND_SELECT("존재하지 않는 스크랩입니다.", 10002);

    private final String message;
    private final Integer code;
}
