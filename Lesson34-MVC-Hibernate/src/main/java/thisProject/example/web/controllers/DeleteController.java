package thisProject.example.web.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import thisProject.example.dto.PersonDto;
import thisProject.example.service.impl.PersonDaoImpl;

import java.util.List;

@RequiredArgsConstructor

@Controller
@RequestMapping("/delete")
public class DeleteController {

    private final PersonDaoImpl dao;

    @GetMapping
    public String getPage(){
        return "next";
    }

    @PostMapping
    public ModelAndView delete(@RequestParam(name = "deleteById")Integer id){
        ModelAndView modelAndView = new ModelAndView("next");

        dao.deleteById(id);

        List<PersonDto> all = dao.getAll();

        modelAndView.addObject("saved", all);

        return modelAndView;

    }

}
