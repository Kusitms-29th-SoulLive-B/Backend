package com.soullive_b.soullive_be.domain.model.dto.response;

import com.soullive_b.soullive_be.domain.keyword.dto.response.KeywordResponse;
import com.soullive_b.soullive_be.domain.model.entity.Model;
import com.soullive_b.soullive_be.domain.modelkeyword.entity.ModelKeyword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class SelectedModelResponse {
    private Long modelId;

    private String name;

    private String imageUrl;

    private String type;

    private List<KeywordResponse> keywords;

    private String enterprise;

    public static SelectedModelResponse of(Model model, String enterprise) {
        List<KeywordResponse> keywords = model.getModelKeywords().stream()
                .map(ModelKeyword::getKeyword)
                .map(KeywordResponse::of)
                .toList();
        return SelectedModelResponse.builder()
                .modelId(model.getId())
                .name(model.getName())
                .imageUrl(model.getImageUrl())
                .type(model.getType().getDescription())
                .keywords(keywords)
                .enterprise(enterprise)
                .build();
    }
}
