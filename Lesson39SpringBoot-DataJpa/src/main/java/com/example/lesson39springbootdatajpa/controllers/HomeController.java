package com.example.lesson39springbootdatajpa.controllers;


import com.example.lesson39springbootdatajpa.dto.FilmDto;
import com.example.lesson39springbootdatajpa.dto.FilmSearchDto;
import com.example.lesson39springbootdatajpa.entity.FilmEntity;
import com.example.lesson39springbootdatajpa.service.impl.FilmServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RequiredArgsConstructor

@Controller
@RequestMapping("/home")
public class HomeController {
    private final FilmServiceImpl service;

    @GetMapping("")
    public ModelAndView getMainPage(@ModelAttribute("modelFilm") FilmDto filmDto,
                                    @ModelAttribute("searchFilm") FilmSearchDto dto) {
        ModelAndView modelAndView = new ModelAndView("homePage");
        modelAndView.addObject("films", service.findAllOrderByRating());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView get(@Valid @ModelAttribute(name = "modelFilm") FilmDto filmDto,
                            BindingResult bindingResult,
                            @ModelAttribute("searchFilm") FilmSearchDto dto) {
        ModelAndView modelAndView = new ModelAndView("homePage");
        if (!bindingResult.hasFieldErrors()) {

            FilmEntity entity = service.getMapper().toEntity(filmDto);

            service.save(entity);

            modelAndView.addObject("modelFilm", new FilmDto());
        }
        modelAndView.addObject("films", service.findAllOrderByRating());
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView delete(@RequestParam(name = "idToDel") Integer id) {
        service.deleteById(id);
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/update/{idUpdate}")
    public ModelAndView update(@RequestParam(name = "ratingNew") Float rating,
                               @PathVariable(name = "idUpdate") Integer id) {
        service.updateRatingById(rating, id);
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/search")
    public ModelAndView search(@ModelAttribute("searchFilm")FilmSearchDto dto,
                               @ModelAttribute("modelFilm") FilmDto film){
        ModelAndView mainPage = getMainPage(film, dto);
        mainPage.addObject("result", service.findByCriteria(dto));
        return mainPage;
    }
}
