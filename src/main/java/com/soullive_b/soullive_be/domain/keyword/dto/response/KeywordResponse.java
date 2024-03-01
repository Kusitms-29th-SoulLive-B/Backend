package com.soullive_b.soullive_be.domain.keyword.dto.response;

import com.soullive_b.soullive_be.domain.keyword.entity.Keyword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class KeywordResponse {
    private String content;

    public static KeywordResponse of(Keyword keyword) {
        return KeywordResponse.builder()
                .content(keyword.getContent())
                .build();
    }
}
