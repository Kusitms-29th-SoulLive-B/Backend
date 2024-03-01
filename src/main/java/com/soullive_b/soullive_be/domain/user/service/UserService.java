package com.soullive_b.soullive_be.domain.user.service;

import com.soullive_b.soullive_be.domain.user.Entity.User;
import com.soullive_b.soullive_be.domain.user.repository.UserRepository;
import com.soullive_b.soullive_be.domain.user.request.signup.SignupRequest;
import com.soullive_b.soullive_be.domain.user.response.login.LoginResponse;
import com.soullive_b.soullive_be.domain.user.response.signup.SignupResponse;
import com.soullive_b.soullive_be.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    @Value("${jwt.secret}")
    private String secretKey;

    private final UserRepository userRepository;


    /**
     * 로그인 서비스 구현
     * @param kakaoId
     * @return
     */
    public LoginResponse login(Long kakaoId) {
        log.info(kakaoId.toString());
        Boolean isUser = false;
        Long userId;
        String accessToken;

        try {
            userId = userRepository.findBySocialId(kakaoId).getId();
            isUser = true;
        }catch (NullPointerException e){
            userId = 0L;
        }
        accessToken = JwtUtil.createAccessToken(userId, kakaoId, secretKey);

        return LoginResponse.of(isUser, accessToken);
    }

    public SignupResponse signup(Long kakaoId, SignupRequest signupRequest) {
        //User객체 생성 및 request정보 넣기
        Long userId = makeUser(kakaoId, signupRequest);
        return SignupResponse.of(userId);
    }

    private Long makeUser(Long kakaoId, SignupRequest signupRequest) {
        User user = User.builder().build();
        user.setSocialId(kakaoId);
        user.setEnterprise(signupRequest.getEnterprise());
        user.setType(signupRequest.getType());
        user.setEmail(signupRequest.getEmail());
        user.set_active(true);
        user.setApproved(false);

        userRepository.save(user);

        return user.getId();
    }


}
