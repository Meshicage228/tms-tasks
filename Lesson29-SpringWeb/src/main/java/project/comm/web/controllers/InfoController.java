package project.comm.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import project.comm.domain.CustomDB;
import project.comm.userService.UserService;
import project.comm.domain.User;

import javax.validation.Valid;

@Controller
@RequestMapping("/info")
@RequiredArgsConstructor
public class InfoController {
    private final UserService userService;
    @GetMapping
    public ModelAndView showInfoPage(@ModelAttribute(name = "user") User user){
        ModelAndView modelAndView = new ModelAndView("info");
        modelAndView.addObject("users" , userService.showUsers());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addUser(@ModelAttribute(name = "user") @Valid User user, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("info");

        if(!bindingResult.hasFieldErrors()){
            userService.save(user);
            modelAndView.addObject("user", new User());
        }
        modelAndView.addObject("users", userService.showUsers());
        return modelAndView;
    }
}
