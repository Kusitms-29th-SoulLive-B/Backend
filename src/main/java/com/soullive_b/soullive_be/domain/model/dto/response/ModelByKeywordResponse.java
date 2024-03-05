package com.soullive_b.soullive_be.domain.model.dto.response;

import com.soullive_b.soullive_be.domain.advertisement.entity.Advertisement;
import com.soullive_b.soullive_be.domain.model.entity.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public class ModelByKeywordResponse {
    private Long modelId;

    private String productName;

    private String modelName;

    private String content;

    private String imageUrl;

    private LocalDate date;

    public static ModelByKeywordResponse of(Model model, Advertisement advertisement) {
        return ModelByKeywordResponse.builder()
                .modelId(model.getId())
                .productName(advertisement.getProductName())
                .modelName(model.getName())
                .content(advertisement.getContent())
                .imageUrl(advertisement.getImageUrl())
                .date(advertisement.getDate())
                .build();
    }
}
