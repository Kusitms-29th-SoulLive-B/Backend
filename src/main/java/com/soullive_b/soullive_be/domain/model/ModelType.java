package com.soullive_b.soullive_be.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ModelType {
    DUMMY_TYPE("더미 모델 유형"),
    ACTOR("영화・드라마배우");

    private final String description;
}
