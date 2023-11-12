package com.example.lesson39springbootdatajpa.controllers;


import com.example.lesson39springbootdatajpa.dao.FilmRepository;
import com.example.lesson39springbootdatajpa.dto.FilmDto;
import com.example.lesson39springbootdatajpa.entity.FilmEntity;
import com.example.lesson39springbootdatajpa.mappers.FilmMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor

@Controller
@RequestMapping("/home")
public class HomeController {
    private final FilmRepository rep;
    private final FilmMapper mapper;
    @GetMapping("")
    public ModelAndView getMainPage(@ModelAttribute(name = "film")FilmDto filmDto){
        ModelAndView modelAndView = new ModelAndView("homePage");
        
        modelAndView.addObject("films", mapper.toDto(rep.findAll()));
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView get(@Valid @ModelAttribute(name = "film") FilmDto filmDto, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        if(!bindingResult.hasFieldErrors()){

            FilmEntity entity = mapper.toEntity(filmDto);

            rep.save(entity);

            modelAndView.addObject("film", new FilmDto());
        }
        return modelAndView;
    }
    @PostMapping("/delete")
    public ModelAndView delete(@RequestParam(name = "idToDel")Integer id){
        rep.deleteById(id);
        return new ModelAndView("redirect:/home");
    }
}
