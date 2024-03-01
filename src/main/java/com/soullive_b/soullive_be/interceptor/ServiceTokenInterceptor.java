package com.soullive_b.soullive_be.interceptor;

import com.soullive_b.soullive_be.exception.notfound.JwtExpiredException;
import com.soullive_b.soullive_be.exception.notfound.JwtInvalidException;
import com.soullive_b.soullive_be.util.JwtUtil;
import com.soullive_b.soullive_be.validation.TokenValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
@Slf4j
public class ServiceTokenInterceptor implements HandlerInterceptor {
    @Value("${jwt.secret}")
    private String secretKey;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userToken = TokenValidator.tokenValidator(request, response);
        String tokenType = JwtUtil.getTokenHeader(userToken).get("typ").toString();
        log.info(tokenType);

        if(!tokenType.equals("access_token")){
            //토큰 타입이 액세스 토큰이 아닐 경우
            throw new JwtInvalidException();
        }

        if(JwtUtil.isExpired(userToken, secretKey)){
            // 토큰이 만료되었다면 예외 던지기
            throw new JwtExpiredException();
        }

        //카카오Id 토큰으로부터 받아오기
        Long kakaoId = JwtUtil.getKaKaoId(userToken, secretKey);
        request.setAttribute("kakaoId",kakaoId);

        Long userId = JwtUtil.getMemberId(userToken, secretKey);
        request.setAttribute("userId", userId);

        return true;
    }

}
