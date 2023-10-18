package project.comm.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String showInfoPage(){
        return "info";
    }

    @PostMapping
    public ModelAndView addUser(@Valid User user, BindingResult bindingResult, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("info");

        if(bindingResult.hasFieldErrors()){
            bindingResult.getFieldErrors()
                    .forEach(fieldError -> {
                        String field = fieldError.getField();
                        String defaultMessage = fieldError.getDefaultMessage();
                        modelAndView.addObject(field + "Error", defaultMessage);
                    });
        }
        else {
            String title = request.getParameter("jobTitle");
            user.setJobTitle(JobTitle.valueOf(title));
            userService.save(user);
            modelAndView.addObject("users", CustomDB.userList);
        }
        return modelAndView;
    }
}
