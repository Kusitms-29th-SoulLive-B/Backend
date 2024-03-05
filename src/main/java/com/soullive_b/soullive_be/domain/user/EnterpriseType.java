package com.soullive_b.soullive_be.domain.user;

import com.soullive_b.soullive_be.exception.notfound.NotFoundEnterpriseTypeException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnterpriseType {
    DUMMY_TYPE("더미 기업 분류"),
    MARKETING("광고/마케팅"),
    SALES("영업/고객상담"),
    EDUCATION("교육"),
    PRODUCTION("생산/제조"),
    MANAGEMENT("경영/사무"),
    IT("IT");

    private final String description;

    public static EnterpriseType kor2code(String kor) {
        for (EnterpriseType type : values()) {
            if (type.getDescription().equals(kor))
                return type;
        }
        throw new NotFoundEnterpriseTypeException();
    }
}
