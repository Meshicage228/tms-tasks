package com.example.lesson47springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurity {
    @Bean
    public SecurityFilterChain security(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(customizer -> {
            customizer.requestMatchers("/public").permitAll();
            customizer.requestMatchers("/private").authenticated();
            customizer.requestMatchers("/perm").hasAuthority("access");
        });
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }
    @Bean
    public UserDetailsManager manager(){

        UserDetails sasha = User.builder()
                .username("sasha")
                .password("2")
                .build();

        UserDetails oleg = User.builder()
                .username("oleg")
                .authorities("access")
                .password("3")
                .build();

        return new InMemoryUserDetailsManager(sasha, oleg);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
