package com.soullive_b.soullive_be.domain.user.request.signup;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 회원가입 api request 정의
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SignupRequest {
    @NotBlank
    private String enterprise;
}
