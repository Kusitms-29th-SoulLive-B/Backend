package com.soullive_b.soullive_be.config;

import com.soullive_b.soullive_be.argumentResolver.KakaoIdArgumentResolver;
import com.soullive_b.soullive_be.argumentResolver.UserIdArgumentResolver;
import com.soullive_b.soullive_be.interceptor.IdTokenInterceptor;
import com.soullive_b.soullive_be.interceptor.ServiceTokenInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


/**
 *  사전 인증, 인가 처리 구현
 */
@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final IdTokenInterceptor idTokenInterceptor;
    private final ServiceTokenInterceptor serviceTokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(idTokenInterceptor)
                .order(1)
                .addPathPatterns("/user/login");
        registry.addInterceptor(serviceTokenInterceptor)
                .order(1)
                .addPathPatterns("/user/signup")
                .addPathPatterns("/user/home");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new KakaoIdArgumentResolver());
        resolvers.add(new UserIdArgumentResolver());
    }

}
