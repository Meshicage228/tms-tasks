package thisProject.example.web.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import thisProject.example.entity.PersonEntity;
import thisProject.example.service.PersonEntityDaoImpl;

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
    public ModelAndView page(PersonEntity personEntity){
        ModelAndView modelAndView = new ModelAndView("next");
        service.save(personEntity);
        return modelAndView;
    }
}
