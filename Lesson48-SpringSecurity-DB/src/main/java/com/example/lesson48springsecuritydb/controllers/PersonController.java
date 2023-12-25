package com.example.lesson48springsecuritydb.controllers;

import com.example.lesson48springsecuritydb.dto.PersonDto;
import com.example.lesson48springsecuritydb.service.impl.DBUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor

@Controller
@RequestMapping("/user")
public class PersonController {
    private final DBUserDetailsService service;
    @PostMapping("/register")
    public String register(PersonDto dto){
        service.save(dto);
        return "redirect:/auth";
    }
}
