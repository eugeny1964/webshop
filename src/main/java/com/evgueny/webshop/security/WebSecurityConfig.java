package com.evgueny.webshop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
           .csrf().disable()
           .authorizeRequests()
               //.antMatchers(HttpMethod.GET,"/api/good/**").permitAll()
               //.antMatchers("/login*").permitAll()
               .anyRequest().authenticated()
           .and()
           //.httpBasic().disable()
           .formLogin()
               .loginPage("/login")
               .loginProcessingUrl("/login")
               .defaultSuccessUrl("/api/good", true)
               .failureForwardUrl("/login?error=true");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
