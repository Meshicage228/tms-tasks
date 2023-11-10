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
    public ModelAndView getMainPage(){
        return new ModelAndView("homeP");
    }
    @PostMapping
    public ModelAndView get(){
        return new ModelAndView("homeP");
    }
}
