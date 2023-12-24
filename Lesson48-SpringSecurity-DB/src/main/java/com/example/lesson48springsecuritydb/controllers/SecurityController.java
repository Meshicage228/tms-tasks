package com.example.lesson48springsecuritydb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class SecurityController {
    @GetMapping("/auth")
    public String authPage(){
        return "auth";
    }
    @GetMapping("/registration")
    public String login(){
        return "registerPage";
    }
}
