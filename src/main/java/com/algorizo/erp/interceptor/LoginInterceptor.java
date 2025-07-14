package com.algorizo.erp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    public LoginInterceptor() {
        logger.info("LoginInterceptor 생성됨 (Spring이 빈으로 등록)");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("LoginInterceptor 실행됨: 요청된 URL = " + request.getRequestURI());

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("m_id") == null) {
            logger.info("[LoginInterceptor] 세션 없음 로그인 페이지로 리다이렉트");
            response.sendRedirect(request.getContextPath() + "/");
            return false;
        }

        logger.info("LoginInterceptor 로그인 세션 확인됨, 요청 계속 진행");
        return true;
    }
}
