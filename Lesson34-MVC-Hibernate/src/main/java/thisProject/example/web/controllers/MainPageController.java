package thisProject.example.web.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thisProject.example.dto.PersonDto;
import thisProject.example.service.impl.PersonDaoImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Random;

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
    public ModelAndView page(@ModelAttribute("personAttribute") @Valid PersonDto person, BindingResult bindingResult){

        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("mainPage");
            modelAndView.addObject("person", new PersonDto());
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("next");
        PersonDto saved = service.save(person);
        List<PersonDto> all = service.getAll();

        return modelAndView.addObject("saved", all);
    }
}
