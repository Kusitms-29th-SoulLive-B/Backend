package com.soullive_b.soullive_be.domain.user.response;

import com.soullive_b.soullive_be.domain.keyword.dto.response.KeywordResponse;
import com.soullive_b.soullive_be.domain.keyword.entity.Keyword;
import com.soullive_b.soullive_be.domain.model.dto.response.RecommendModelResponse;
import com.soullive_b.soullive_be.domain.model.dto.response.SelectedModelResponse;
import com.soullive_b.soullive_be.domain.model.entity.Model;
import com.soullive_b.soullive_be.domain.user.entity.User;
import com.soullive_b.soullive_be.domain.usermodelselect.entity.UserModelSelect;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class HomeDataResponse {
    private String name;

    private String type;

    private List<RecommendModelResponse> recommendModels;

    private List<SelectedModelResponse> selectedModels;

    private List<KeywordResponse> popularKeywords;

    public static HomeDataResponse of(User user, List<Model> recommendModels, List<UserModelSelect> userModelSelects, List<Keyword> keywords) {
        return HomeDataResponse.builder()
                .name(user.getEnterprise())
                .type(user.getEnterpriseType().getDescription())
                .recommendModels(recommendModels.stream()
                        .map(RecommendModelResponse::of)
                        .toList())
                .selectedModels(userModelSelects.stream()
                        .map((UserModelSelect s) -> SelectedModelResponse.of(s.getModel(), s.getUser().getEnterprise()))
                        .toList())
                .popularKeywords(keywords.stream()
                        .map(KeywordResponse::of)
                        .toList())
                .build();
    }
}
