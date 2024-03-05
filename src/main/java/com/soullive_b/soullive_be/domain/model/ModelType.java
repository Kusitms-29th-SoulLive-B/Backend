package com.soullive_b.soullive_be.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ModelType {
    DUMMY_TYPE("더미 모델 유형"),
    ACTOR("배우"),
    INFLUENCER("인플루언서"),
    ATHLETE("운동선수"),
    IDOL("아이돌 가수");

    private final String description;
}
