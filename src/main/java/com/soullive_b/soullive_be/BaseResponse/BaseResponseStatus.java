package com.soullive_b.soullive_be.BaseResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor

public enum BaseResponseStatus implements ResponseStatus{
    SUCCESS(1000, HttpStatus.OK.value(), "요청에 성공하였습니다.");

    private final int code;
    private final int status;
    private final String message;
    @Override
    public int getCode() {
        return code;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
