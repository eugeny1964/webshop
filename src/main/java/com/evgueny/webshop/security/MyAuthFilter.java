package com.evgueny.webshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAuthFilter extends OncePerRequestFilter {

    @Autowired
    private CookieService cookieService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if(httpServletRequest.getRequestURI().startsWith("/api/**")) {
            System.out.println("MyAuthFilter.doFilterInternal");
            Cookie bearer = WebUtils.getCookie(httpServletRequest, "BEARER");
            if (bearer == null) {
                throw new RuntimeException("No cookie");
            }
            if (!cookieService.checkCookie(bearer.getValue())) {
                throw new RuntimeException("Not valid cookie");
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
