package com.soullive_b.soullive_be.domain.user;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnterpriseType {
    DUMMY_TYPE("더미 기업 분류");

    private final String description;
}
