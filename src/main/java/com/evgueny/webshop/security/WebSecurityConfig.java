package com.evgueny.webshop.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterRegistration;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
       // super.configure(http);
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/login").permitAll()
                .and().logout().permitAll();
    }*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .addFilterBefore(myLoginFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(myAuthFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                    .antMatchers("/api/**").hasAuthority("ADMIN")
                    .antMatchers(HttpMethod.GET, "/api/good*").hasAuthority("USER")
                    .antMatchers(HttpMethod.POST, "/api/orders").hasAuthority("USER")
                    .antMatchers(HttpMethod.PUT, "/api/orders").hasAuthority("USER")
                    .anyRequest().authenticated()
                .and()
               .formLogin().defaultSuccessUrl("/api/good")
                .and()
                .httpBasic().disable()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public MyLoginFilter myLoginFilter() throws Exception {
        return new MyLoginFilter(authenticationManager());
    }

    @Bean
    public MyAuthFilter  myAuthFilter(){
        return new MyAuthFilter();
    }

    @Bean
    public FilterRegistrationBean<MyAuthFilter> myAuthFilterFilterRegistrationBean(){
        FilterRegistrationBean<MyAuthFilter> myAuthFilterFilterRegistrationBean=new FilterRegistrationBean<>();
        myAuthFilterFilterRegistrationBean.setFilter(myAuthFilter());
        myAuthFilterFilterRegistrationBean.addUrlPatterns("/api/**");
        return myAuthFilterFilterRegistrationBean;
    }
}
