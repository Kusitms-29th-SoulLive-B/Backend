package com.soullive_b.soullive_be.domain.user.controller;

import com.soullive_b.soullive_be.BaseResponse.BaseResponse;
import com.soullive_b.soullive_be.argumentResolver.customAnnotation.KakaoId;
import com.soullive_b.soullive_be.domain.user.response.LoginResponse;
import com.soullive_b.soullive_be.domain.user.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/login")
    public BaseResponse<LoginResponse> login(@KakaoId Long kakaoId){
        return new BaseResponse<>(userService.login(kakaoId));
    }

    @PostMapping("/signup")
    public BaseResponse<SignupResponse> signup(@Validated @ModelAttribute SignupRequest signupRequest,
                                               @KakaoId Long kakaoId){
        return new BaseResponse<>(userService.signup(kakaoId, signupRequest));
    }

    @GetMapping("/home")
    public BaseResponse<HomeDataResponse> getHomeData(){//@KakaoId Long kakaoId
        Long kakaoId = 7L;//임시 소셜id
        return new BaseResponse<>(userService.getHomeData(kakaoId));
    }
}
