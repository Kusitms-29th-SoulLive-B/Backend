package com.soullive_b.soullive_be.domain.model.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ModelByKeywordRequest {
    private String keyword;
}
