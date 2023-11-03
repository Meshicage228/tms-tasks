package thisProject.example.web.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView page(@RequestParam(name = "p_name") String name,
                             @RequestParam(name = "p_password") String password,
                             @RequestParam(name = "p_email") String email){
        ModelAndView modelAndView = new ModelAndView("next");

        PersonEntity person = PersonEntity.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();

        modelAndView.addObject("person", person);

        return modelAndView;
    }
}
