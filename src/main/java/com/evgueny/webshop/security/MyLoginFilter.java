package com.evgueny.webshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


public class MyLoginFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    CookieService cookieService;

    public MyLoginFilter(AuthenticationManager authenticationManager) {
        super();
        setAuthenticationManager(authenticationManager);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        System.out.println("MyLoginFilter.successfulAuthentication");
        Cookie cookie = new Cookie("BEARER", cookieService.getCookie());
        response.addCookie(cookie);

        chain.doFilter(request, response);
    }
}
