package com.soullive_b.soullive_be.domain.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.codegen.Keywords;
import com.soullive_b.soullive_be.domain.activity.dto.response.ActivityResponse;
import com.soullive_b.soullive_be.domain.activity.entity.Activity;
import com.soullive_b.soullive_be.domain.advertisement.dto.response.AdvertisementResponse;
import com.soullive_b.soullive_be.domain.advertisement.entity.Advertisement;
import com.soullive_b.soullive_be.domain.issue.dto.response.IssueResponse;
import com.soullive_b.soullive_be.domain.issue.entity.Issue;
import com.soullive_b.soullive_be.domain.keyword.dto.response.KeywordResponse;
import com.soullive_b.soullive_be.domain.keyword.entity.Keyword;
import com.soullive_b.soullive_be.domain.model.ModelType;
import com.soullive_b.soullive_be.domain.model.entity.Model;
import com.soullive_b.soullive_be.domain.popularity.dto.response.PopularityResponse;
import com.soullive_b.soullive_be.domain.popularity.entity.Popularity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class ModelDetailResponse {
    private String name;

    private String description;

    private String type;

    private String agency;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy년 데뷔")
    private LocalDate debutAt;

    private List<KeywordResponse> keywords;

    private List<IssueResponse> issues;

    private List<ActivityResponse> activities;

    private List<AdvertisementResponse> advertisements;

    private List<PopularityResponse> popularities;

    private String email;

    public static ModelDetailResponse of(Model model, List<Keyword> keywords, List<Issue> issues, List<Activity> activities, List<Advertisement> advertisements, List<Popularity> popularities){
        return ModelDetailResponse.builder()
                .name(model.getName())
                .type(model.getType().getDescription())
                .agency(model.getAgency())
                .debutAt(model.getDebutAt())
                .keywords(keywords.stream()
                        .map(KeywordResponse::of)
                        .toList())
                .issues(issues.stream()
                        .map(IssueResponse::of)
                        .toList())
                .activities(activities.stream()
                        .map(ActivityResponse::of)
                        .toList())
                .advertisements(advertisements.stream()
                        .map(AdvertisementResponse::of)
                        .toList())
                .popularities(popularities.stream()
                        .map(PopularityResponse::of)
                        .toList())
                .build();
    }
}
