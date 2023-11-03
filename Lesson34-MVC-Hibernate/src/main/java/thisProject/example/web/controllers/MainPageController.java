package thisProject.example.web.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thisProject.example.entity.PersonEntity;
import thisProject.example.service.PersonEntityDaoImpl;

import java.time.LocalDate;
import java.util.Date;

@RequiredArgsConstructor

@Controller
@RequestMapping("/mainPage")
public class MainPageController {
    private final PersonEntityDaoImpl service;
    @GetMapping
    public String home(){
        return "mainHomePage";
    }

    @PostMapping
    public ModelAndView page(@ModelAttribute(name = "myPerson") PersonEntity person){
        ModelAndView modelAndView = new ModelAndView("next");

        person.setTimeOfCreation(new Date());

        modelAndView.addObject("person", person);

        return modelAndView;
    }
}
