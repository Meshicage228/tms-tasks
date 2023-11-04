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
    @GetMapping("")
    public ModelAndView showInfoPage(@ModelAttribute(name = "per") PersonDto user){
        ModelAndView modelAndView = new ModelAndView("mainHomePage");
        modelAndView.addObject("saved" , service.getAll());
        return modelAndView;
    }

    @PostMapping("")
    public ModelAndView page(@ModelAttribute(name = "per")@Valid PersonDto personDto, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("mainHomePage");
        if(!bindingResult.hasFieldErrors()){
            service.save(personDto);
            modelAndView.addObject("per", new PersonDto());
        }
        modelAndView.addObject("saved", service.getAll());

        return modelAndView;
    }
    @PostMapping("/delete")
    public ModelAndView del(@RequestParam(name = "deleteById")Integer id){
        ModelAndView modelAndView = new ModelAndView("mainHomePage");

        service.deleteById(id);

        List<PersonDto> all = service.getAll();

        modelAndView.addObject("saved", all);
        modelAndView.addObject("per", new PersonDto());

        return modelAndView;

    }
}
