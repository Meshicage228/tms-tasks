package thisProject.example.web.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thisProject.example.dto.PersonDto;
import thisProject.example.service.impl.PersonDaoImpl;

import java.util.List;

@RequiredArgsConstructor

@Controller
@RequestMapping("/mainPage")
public class MainPageController {
    private final PersonDaoImpl service;
    @GetMapping
    public String home(){
        return "mainHomePage";
    }

    @PostMapping
    public ModelAndView page(/*@ModelAttribute(name = "myPerson") */PersonDto person){
        PersonDto saved = service.save(person);

        ModelAndView modelAndView = new ModelAndView("next");

        List<PersonDto> all = service.getAll();

        modelAndView.addObject("saved", all);

        return modelAndView;
    }
}
