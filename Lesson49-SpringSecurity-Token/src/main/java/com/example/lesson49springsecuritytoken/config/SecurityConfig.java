package com.example.lesson49springsecuritytoken.config;

import com.example.lesson49springsecuritytoken.config.filters.TokenGenerationFilter;
import com.example.lesson49springsecuritytoken.config.filters.TokenValidationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.context.SecurityContextHolderFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;


@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final TokenValidationFilter validationFilter;
    private final TokenGenerationFilter generationFilter;
    @Bean
    public SecurityFilterChain chain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(registry -> {
            registry.requestMatchers("/admin").hasRole("ADMIN");
            registry.requestMatchers("/auth").permitAll();
        });
        http.cors(AbstractHttpConfigurer::disable);
        http.csrf(AbstractHttpConfigurer::disable);

        http.addFilterAfter(generationFilter, LogoutFilter.class);
        http.addFilterBefore(validationFilter, SecurityContextHolderAwareRequestFilter.class);
        return http.build();
    }
}
