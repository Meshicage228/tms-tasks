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
import project.comm.domain.JobTitle;
import project.comm.userService.UserService;
import project.comm.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/info")
@RequiredArgsConstructor
public class InfoController {
    private final UserService userService;
    @GetMapping
    public ModelAndView showInfoPage(User user){
        ModelAndView modelAndView = new ModelAndView("info");
        modelAndView.addObject("users" , CustomDB.userList);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addUser(@ModelAttribute(name = "user") @Valid User user, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("info");

        if(!bindingResult.hasFieldErrors()){
            userService.save(user);
        }
        modelAndView.addObject("users", CustomDB.userList);
        return modelAndView;
    }
}
