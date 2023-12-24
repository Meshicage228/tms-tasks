package com.example.lesson48springsecuritydb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.beans.Encoder;

@Configuration
public class SpringSecurityConfig {
    @Bean
    public SecurityFilterChain chain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(customizer -> {
            customizer.requestMatchers("/auth", "/user/register", "/registration").permitAll();
            customizer.requestMatchers("/home", "/user/logout").authenticated();
        });
        http.httpBasic(Customizer.withDefaults());
        http.formLogin(cust -> {
            cust.loginPage("/auth");
            cust.loginProcessingUrl("/auth");
            cust.usernameParameter("login");
            cust.passwordParameter("cred");
            cust.successHandler((request, response, authentication) -> {
                response.sendRedirect("/home");
            });
            cust.failureHandler((request, response, exception) -> {
                response.sendRedirect("/auth");
            });
        });
        http.logout(cust -> {
           cust.logoutUrl("/user/logout");
           cust.invalidateHttpSession(true);
        });
        return http.build();
    }
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
