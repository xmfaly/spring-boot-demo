package com.example.intercepterdemo.intercepter;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthIntercepter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 不是本项目的不进行拦截
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod method = (HandlerMethod) handler;
        NoAuth noAuth = method.getMethodAnnotation(NoAuth.class);
        if (noAuth != null) {
            return true;
        } else {
            if (request.getSession().getAttribute("admin") == null) {
                response.sendRedirect("/login");
                return false;
            }
            return true;
        }
    }
}
