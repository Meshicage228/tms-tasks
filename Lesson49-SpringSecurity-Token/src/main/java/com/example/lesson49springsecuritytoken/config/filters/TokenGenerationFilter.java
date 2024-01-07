package com.example.lesson49springsecuritytoken.config.filters;

import com.example.lesson49springsecuritytoken.repository.UserRepository;
import com.example.lesson49springsecuritytoken.service.impl.TokenService;
import com.example.lesson49springsecuritytoken.service.impl.UserServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@RequiredArgsConstructor

@Service
public class TokenGenerationFilter extends OncePerRequestFilter {
    private final UserServiceImpl service;
    private final TokenService tokenService;
    private final BCryptPasswordEncoder encoder;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String password = request.getParameter("password");

        String username = request.getParameter("username");

        if (username != null && !username.isBlank()) {
            UserDetails userDetails = service.loadUserByUsername(username);

            if(encoder.matches(password, userDetails.getPassword())){
                String token = tokenService.createToken(userDetails);
                response.setHeader("jwt", token);
            }
        }
        filterChain.doFilter(request, response);
    }
}
