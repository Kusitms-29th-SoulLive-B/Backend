package com.soullive_b.soullive_be.domain.model.dto.response;

import com.soullive_b.soullive_be.domain.keyword.dto.response.KeywordResponse;
import com.soullive_b.soullive_be.domain.model.entity.Model;
import com.soullive_b.soullive_be.domain.modelkeyword.entity.ModelKeyword;
import com.soullive_b.soullive_be.domain.popularity.entity.Popularity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class ModelResponse {
    private Long modelId;

    private String name;

    private String imageUrl;

    private String type;

    private List<KeywordResponse> keywords;

    private String target;

    public static ModelResponse of(Model model, Popularity popularity) {
        List<KeywordResponse> keywords = model.getModelKeywords().stream()
                .map(ModelKeyword::getKeyword)
                .map(KeywordResponse::of)
                .toList();
        String target = popularity.getAge() + "대 " + popularity.getGender().getDescription();
        return ModelResponse.builder()
                .modelId(model.getId())
                .name(model.getName())
                .imageUrl(model.getImageUrl())
                .type(model.getType().getDescription())
                .keywords(keywords)
                .target(target)
                .build();
    }
}
