//package thisProject.example.web.controllers;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import thisProject.example.dto.PersonDto;
//import thisProject.example.service.impl.PersonDaoImpl;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//
//@Controller
//@RequestMapping("/delete")
//public class DeleteController {
//
//    private final PersonDaoImpl service;
//
//    @GetMapping
//    public ModelAndView showInfoPage(){
//        ModelAndView modelAndView = new ModelAndView("mainHomePage");
//        modelAndView.addObject("saved" , service.getAll());
//        return modelAndView;
//    }
//
//}
