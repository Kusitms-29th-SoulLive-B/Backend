package com.soullive_b.soullive_be.domain.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginResponse {
    private Boolean isUser; // 회원인지 아닌지 알려주는 변수
    private String accessToken; // 서비스에서 발급한 액세스 토큰

    public static LoginResponse of(
            Boolean isUser,
            String accessToken
    ){
        return LoginResponse.builder()
                .isUser(isUser)
                .accessToken(accessToken)
                .build();
    }
}
