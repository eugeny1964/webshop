package com.evgueny.webshop.security;

import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class CookieService {
    private Set<String> cookies= new HashSet<>();

    public String getCookie(){
        String s = UUID.randomUUID().toString();
        cookies.add(s);
        return s;
    }

    public boolean checkCookie(String value){
       return cookies.contains(value);
    }
}
