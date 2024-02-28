package com.soullive_b.soullive_be.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionContent {
    NOT_FOUND_USER("유저가 존재하지 않습니다.");

    private final String message;
}
