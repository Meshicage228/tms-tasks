package com.example.lesson39springbootdatajpa.controllers;


import com.example.lesson39springbootdatajpa.dao.FilmRepository;
import com.example.lesson39springbootdatajpa.dto.FilmDto;
import com.example.lesson39springbootdatajpa.entity.FilmEntity;
import com.example.lesson39springbootdatajpa.mappers.FilmMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        ModelAndView modelAndView = new ModelAndView("mainPage");
        List<FilmDto> result = new ArrayList<>();

        for (FilmEntity ob : rep.findAll()) {
            result.add(mapper.toDto(ob));
        }
        modelAndView.addObject("films", result);
        return modelAndView;
    }
    @PostMapping("/save")
    public String get(@ModelAttribute(name = "film") @Valid FilmDto filmDto, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("mainPage");
        if(!bindingResult.hasFieldErrors()){

            FilmEntity entity = mapper.toEntity(filmDto);

            rep.save(entity);

            modelAndView.addObject("film", new FilmDto());
        }
        List<FilmDto> result = new ArrayList<>();

        for (FilmEntity ob : rep.findAll()) {
            result.add(mapper.toDto(ob));
        }
        modelAndView.addObject("films", result);

        return "mainPage";
    }
}
