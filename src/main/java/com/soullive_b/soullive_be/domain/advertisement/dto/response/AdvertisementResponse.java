package com.soullive_b.soullive_be.domain.advertisement.dto.response;

import com.soullive_b.soullive_be.domain.advertisement.entity.Advertisement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AdvertisementResponse {
    private String logo_url;

    private String image_url;

    public static AdvertisementResponse of(Advertisement advertisement) {
        return AdvertisementResponse.builder()
                .logo_url(advertisement.getLogoUrl())
                .image_url(advertisement.getImageUrl())
                .build();
    }
}
