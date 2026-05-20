package com.shop.online_shop.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class KabylbaevAlikhanLoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) {
        log.info("REQUEST: {} {} from IP: {}",
                request.getMethod(), request.getRequestURI(), request.getRemoteAddr());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) {
        if (ex != null) {
            log.error("ERROR: {} {} - {}",
                    request.getMethod(), request.getRequestURI(), ex.getMessage());
        } else {
            log.info("RESPONSE: {} {} - Status: {}",
                    request.getMethod(), request.getRequestURI(), response.getStatus());
        }
    }
}
