package com.soullive_b.soullive_be.domain.user.service;

import com.soullive_b.soullive_be.domain.user.repository.MemberRepository;
import com.soullive_b.soullive_be.domain.user.response.LoginResponse;
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

    private final MemberRepository memberRepository;


    /**
     * 로그인 서비스 구현
     * @param kakaoId
     * @return
     */
    public LoginResponse login(Long kakaoId) {
        Boolean isUser = false;
        Long userId;
        String accessToken;

        userId = memberRepository.findBySocialId(kakaoId).getId();
        accessToken = JwtUtil.createAccessToken(userId, kakaoId, secretKey);

        return LoginResponse.of(isUser, accessToken);
    }
}
