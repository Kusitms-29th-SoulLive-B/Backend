package com.soullive_b.soullive_be.domain.popularity.dto.response;

import com.soullive_b.soullive_be.domain.popularity.Gender;
import com.soullive_b.soullive_be.domain.popularity.entity.Popularity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
public class PopularityResponse {
    private Integer age;

    private String gender;

    private Integer score;

    public static PopularityResponse of(Popularity popularity) {
        return PopularityResponse.builder()
                .age(popularity.getAge())
                .gender(popularity.getGender().getDescription())
                .score(popularity.getScore())
                .build();
    }
}
