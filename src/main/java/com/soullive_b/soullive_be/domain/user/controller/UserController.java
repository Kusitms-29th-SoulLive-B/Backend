package com.soullive_b.soullive_be.domain.user.controller;

import com.soullive_b.soullive_be.BaseResponse.BaseResponse;
import com.soullive_b.soullive_be.argumentResolver.customAnnotation.KakaoId;
import com.soullive_b.soullive_be.argumentResolver.customAnnotation.UserId;
import com.soullive_b.soullive_be.domain.user.response.HomeDataResponse;
import com.soullive_b.soullive_be.domain.user.request.signup.SignupRequest;
import com.soullive_b.soullive_be.domain.user.response.login.LoginResponse;
import com.soullive_b.soullive_be.domain.user.response.signup.SignupResponse;
import com.soullive_b.soullive_be.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
@Tag(name= "user", description = "사용자 관련 api")
public class UserController {
    private final UserService userService;

    @Operation(summary = "카카오 소셜로그인하기", description = """
            카카오에서 발급받은 id토큰을 Authorization Header에 포함하여 요청해주세요. (앞에 Bearer를 붙여야 합니다.)
            
            앞으로 api 요청시에 같이 사용될 엑세스 토큰이 발급됩니다.
            
            반횐된 isUser값이 false이면 회원가입이 안된 유저이므로 받은 액세스토큰으로 회원가입 api부터 이용해주세요!
            """)
    @GetMapping("/login")
    public BaseResponse<LoginResponse> login(@Parameter(hidden = true) @KakaoId Long kakaoId){
        return new BaseResponse<>(userService.login(kakaoId));
    }

    @Operation(summary = "회원가입하기(온보딩 정보 입력하기)", description = """
            로그인시 발급받은 엑세스 토큰을 Authorization Header에 포함하여 요청해주세요. (앞에 Bearer를 붙여야 합니다.)
            
            주의: request body에 담는것이 아닌 url parameter 형식으로 온보딩 정보를 입력해주세요
            (ex: [url]?exterprise=???&type=???&email=???)
            
            현재 온보딩 정보로 입력 가능한 기업 분류
            (광고/마케팅, 영업/고객상담, 교육, 생산/제조, 경영/사무, IT)
            """)
    @PostMapping("/signup")
    public BaseResponse<SignupResponse> signup(@Validated @ModelAttribute SignupRequest signupRequest,
                                               @Parameter(hidden = true) @KakaoId Long kakaoId){
        return new BaseResponse<>(userService.signup(kakaoId, signupRequest));
    }

    @Operation(summary = "사용자 정보에 기반함 홈 데이터 가져오기", description = """
            로그인시 발급받은 엑세스 토큰을 Authorization Header에 포함하여 요청해주세요. (앞에 Bearer를 붙여야 합니다.)
            
            사용자 정보를 기반한 홈 데이터가 반환됩니다.
            """)
    @GetMapping("/home")
    public BaseResponse<HomeDataResponse> getHomeData(@Parameter(hidden = true) @KakaoId Long kakaoId){
        return new BaseResponse<>(userService.getHomeData(kakaoId));
    }
}
