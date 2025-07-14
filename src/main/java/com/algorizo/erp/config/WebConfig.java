package com.algorizo.erp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.algorizo.erp.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(WebConfig.class);

    @Autowired
    private LoginInterceptor loginInterceptor; 

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("WebConfig - addInterceptors() 실행됨"); // Interceptor 등록 로그
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/members/**", "/home/**", "/stock/**", "/contract/**", "/order/**", "/product/**", "/company/**", "/plans/**", "/inbound/**", "/outbound/**") 
                .excludePathPatterns("/", "/login", "/register");  
    }
}

