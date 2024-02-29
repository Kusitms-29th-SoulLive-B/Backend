package com.soullive_b.soullive_be.domain.activity.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.soullive_b.soullive_be.domain.activity.entity.Activity;
import com.soullive_b.soullive_be.domain.model.entity.Model;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public class ActivityResponse {
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private LocalDate date;

    public static ActivityResponse of(Activity activity) {
        return ActivityResponse.builder()
                .content(activity.getContent())
                .date(activity.getDate())
                .build();
    }
}
