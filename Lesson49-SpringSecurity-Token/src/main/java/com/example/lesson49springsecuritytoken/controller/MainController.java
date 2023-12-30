package com.example.lesson49springsecuritytoken.controller;

import com.example.lesson49springsecuritytoken.dto.UserDto;
import com.example.lesson49springsecuritytoken.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor

@RestController
@RequestMapping
public class MainController {

    private final UserServiceImpl service;

    @GetMapping("/home")
    public String homePage(){
        return "homePage";
    }
    @GetMapping("/admin")
    public String admin(){
        return "adminPage";
    }

    @PostMapping("/auth")
    public ResponseEntity<UserDto> save(@RequestBody UserDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.save(dto));
    }
}
