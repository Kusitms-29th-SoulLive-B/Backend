package com.soullive_b.soullive_be.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ExceptionResponse {
    private String message;

    public static ExceptionResponse of(String message) {
        return ExceptionResponse.builder()
                .message(message)
                .build();
    }
}
