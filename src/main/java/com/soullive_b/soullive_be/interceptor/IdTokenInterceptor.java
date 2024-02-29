package com.soullive_b.soullive_be.interceptor;


import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkException;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.soullive_b.soullive_be.exception.jwt.JwtExpiredException;
import com.soullive_b.soullive_be.exception.jwt.JwtInvalidException;
import com.soullive_b.soullive_be.provider.CustomJwkProvider;
import com.soullive_b.soullive_be.util.JwtUtil;
import com.soullive_b.soullive_be.validation.TokenValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * Class Description
 *
 * Authorization Header로 들어온 idToken의 유효성 검사를 해주는
 * Interceptor클래스 입니다.
 *
 * @author 김영록
 * @version 1.0.0
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class IdTokenInterceptor implements HandlerInterceptor {
    /**
     * clientId : 카카오 소셜 로그인 서비스에서 제공하는 client-id
     * BASIC_TYPE_PREFIX : 토큰이 Bearer로 시작하는지 확인하는 용도로 쓰임
     */
    @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
    private String clientId;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String idToken = TokenValidator.tokenValidator(request, response);
        log.info(idToken);

        Map<String, Object> payload = JwtUtil.getTokenPayload(idToken);

        //페이로드 검증
        if(!validatePayload(payload)){
            throw new JwtInvalidException();
        }

        //서명 검증
        if(!validateSign(idToken)){
            throw new JwtInvalidException();
        }

        //카카오id 가져오기
        Long kakaoId = Long.parseLong(payload.get("sub").toString());
        log.info("kakao_id = {}", kakaoId);
        request.setAttribute("kakaoId", kakaoId);
        return true;
    }

    /**
     * idToken의 페이로드를 검증하는 부분이다.
     * @param payload id Token의 payload정보를 map형식으로 가지고 있다
     * @param nonce 카카오 소셜 로그인에서 제공하는 nonce값
     * @return
     */
    public boolean validatePayload(Map<String, Object> payload){
        log.info("start validatePayload");
        // 페이로드의 iss 값이 https://kauth.kakao.com와 일치하는지 확인
        if(!payload.get("iss").equals("https://kauth.kakao.com")){
            log.error("uri 불일치");
            return false;
        }
        // 페이로드의 aud 값이 서비스 앱 키와 일치하는지 확인
        if(!payload.get("aud").equals(clientId)){
            log.error("client_id 불일치");
            return false;
        }

        //페이로드의 exp 값이 현재 UNIX 타임스탬프(Timestamp)보다 큰 값인지 확인(ID 토큰이 만료되지 않았는지 확인)
        Long exp = Long.parseLong(payload.get("exp").toString());
        Long now = System.currentTimeMillis();

        log.info("exp = {}", exp);
        log.info("now = {}", now);

        if(exp > now){
            log.error("유효기간 만료");
            throw new JwtExpiredException();
        }

        return true;
    }
    /**
     * idToken의 서명부분을 검증하는 부분이다.
     * 서명부분을 검증하는 로직은 다음의 사이트를 참고함
     * https://kakao-tam.tistory.com/130
     * @param idToken idToken정보
     * @return
     */
    public Boolean validateSign(String idToken) throws JwkException {
        log.info("사인 검증");

        /**
         * 로그를 보니깐 여기서도 만료된 토큰과, 유효하지 않은 부분을 찾아내더라고
         */
        try{
            // 1. 검증없이 디코딩
            DecodedJWT jwtOrigin = JWT.decode(idToken);

            // 2. 공개키 프로바이더 준비
            JwkProvider provider = CustomJwkProvider.getInstance();
            Jwk jwk = provider.get(jwtOrigin.getKeyId());

            // 3. 검증 및 디코딩
            Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) jwk.getPublicKey(), null);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();

            DecodedJWT jwt = verifier.verify(idToken);
        }catch (SignatureVerificationException | JWTDecodeException e){
            throw new JwtInvalidException();
        }catch (TokenExpiredException e){
            throw new JwtExpiredException();
        }


        return true;
    }
}
