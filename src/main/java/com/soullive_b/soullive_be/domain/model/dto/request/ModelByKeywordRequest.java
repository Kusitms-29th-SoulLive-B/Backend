package com.soullive_b.soullive_be.domain.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ModelByKeywordRequest {
    @Schema(defaultValue = "고급스러운")
    @NotBlank(message = "키워드 정보는 비어있을 수 없습니다.")
    private String keyword;
}
