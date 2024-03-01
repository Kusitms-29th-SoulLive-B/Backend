package com.soullive_b.soullive_be.domain.user.response.signup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SignupResponse {
    private Long userId;

    public static SignupResponse of(Long userId){
        return SignupResponse.builder()
                .userId(userId)
                .build();
    }
}
