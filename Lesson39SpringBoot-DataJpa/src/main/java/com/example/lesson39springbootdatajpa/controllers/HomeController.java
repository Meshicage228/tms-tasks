package com.example.lesson39springbootdatajpa.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public String getMainPage(){
        return "homeP";
    }
    @PostMapping
    public String get(){
        return "homeP";
    }
}
