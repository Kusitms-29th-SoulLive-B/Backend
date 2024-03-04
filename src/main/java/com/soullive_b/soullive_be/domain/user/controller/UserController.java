package com.soullive_b.soullive_be.domain.user.controller;

import com.soullive_b.soullive_be.BaseResponse.BaseResponse;
import com.soullive_b.soullive_be.argumentResolver.customAnnotation.KakaoId;
import com.soullive_b.soullive_be.argumentResolver.customAnnotation.UserId;
import com.soullive_b.soullive_be.domain.user.response.HomeDataResponse;
import com.soullive_b.soullive_be.domain.user.request.signup.SignupRequest;
import com.soullive_b.soullive_be.domain.user.response.login.LoginResponse;
import com.soullive_b.soullive_be.domain.user.response.signup.SignupResponse;
import com.soullive_b.soullive_be.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
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
    public BaseResponse<HomeDataResponse> getHomeData(@KakaoId Long kakaoId){
        return new BaseResponse<>(userService.getHomeData(kakaoId));
    }
}
