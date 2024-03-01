package com.soullive_b.soullive_be.domain.user.service;

import com.soullive_b.soullive_be.domain.keyword.entity.Keyword;
import com.soullive_b.soullive_be.domain.keyword.repository.KeywordRepository;
import com.soullive_b.soullive_be.domain.model.entity.Model;
import com.soullive_b.soullive_be.domain.model.repository.ModelRepository;
import com.soullive_b.soullive_be.domain.user.dto.response.HomeDataResponse;
import com.soullive_b.soullive_be.domain.user.entity.User;
import com.soullive_b.soullive_be.domain.user.repository.UserRepository;
import com.soullive_b.soullive_be.domain.user.response.LoginResponse;
import com.soullive_b.soullive_be.domain.usermodelselect.entity.UserModelSelect;
import com.soullive_b.soullive_be.domain.usermodelselect.repository.UserModelSelectRepository;
import com.soullive_b.soullive_be.exception.notfound.NotFoundUserException;
import com.soullive_b.soullive_be.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    @Value("${jwt.secret}")
    private String secretKey;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final UserModelSelectRepository userModelSelectRepository;
    private final KeywordRepository keywordRepository;

    /**
     * 로그인 서비스 구현
     *
     * @param kakaoId
     * @return
     */
    public LoginResponse login(Long kakaoId) {
        log.info(kakaoId.toString());
        Boolean isUser = false;
        Long userId;
        String accessToken;

        try {
            userId = userRepository.findBySocialId(kakaoId).orElse(null).getId();
            isUser = true;
        } catch (NullPointerException e) {
            userId = 0L;
        }
        accessToken = JwtUtil.createAccessToken(userId, kakaoId, secretKey);

        return LoginResponse.of(isUser, accessToken);
    }

    public HomeDataResponse getHomeData(Long kakaoId) {
        User user = userRepository.findBySocialId(kakaoId)
                .orElseThrow(NotFoundUserException::new);
        List<Model> recommendModels = modelRepository.findTop6ByOrderByIdAsc();
        List<UserModelSelect> userModelSelects = userModelSelectRepository.findByEnterpriseType(user.getType());
        List<Keyword> keywords = keywordRepository.findTop4ByOrderByPreferenceDesc();
        return HomeDataResponse.of(
                user,
                recommendModels,
                userModelSelects,
                keywords
        );
    }
}
