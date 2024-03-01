package com.soullive_b.soullive_be.domain.user.request.signup;

import jakarta.validation.constraints.Email;
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
    @NotBlank(message = "enterprise : 기업명이 비어있으면 안됩니다.")
    private String enterprise;
    @NotBlank(message = "type : 기업분류가 비어있으면 안됩니다.")
    private String type;
    @Email(message = "email : 올바른 메일 형식을 지켜주세요")
    private String email;
}
