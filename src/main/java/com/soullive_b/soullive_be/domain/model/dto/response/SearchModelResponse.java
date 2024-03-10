package com.soullive_b.soullive_be.domain.model.dto.response;

import com.soullive_b.soullive_be.domain.model.entity.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class SearchModelResponse {
    Long modelId;
    String modelName;

    public static SearchModelResponse of(Model model) {
        return SearchModelResponse.builder()
                .modelId(model.getId())
                .modelName(model.getName())
                .build();
    }
}
