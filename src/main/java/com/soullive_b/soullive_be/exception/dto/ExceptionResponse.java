package com.soullive_b.soullive_be.exception.dto;

import com.soullive_b.soullive_be.exception.ExceptionContent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ExceptionResponse {
    private String message;
    private Integer code;

    public static ExceptionResponse of(ExceptionContent content) {
        return ExceptionResponse.builder()
                .message(content.getMessage())
                .code(content.getCode())
                .build();
    }
}
