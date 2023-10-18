package project.comm.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.comm.domain.JobTitle;
import project.comm.userService.UserService;
import project.comm.domain.User;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/info")
@RequiredArgsConstructor
public class InfoController {
    private final UserService userService;
    @GetMapping
    public String showInfoPage(){
        return "info";
    }


    // КАК МНЕ ЗАСЕТАТЬ С UI БЕЗ РЕКВЕСТА ЕНАМ В ЮЗЕРА?
    // И ПОЧЕМУ-ТО НЕ ПОКЛЮЧИЛСЯ CSS((
    @PostMapping
    public String addUser(User user, HttpServletRequest request){
        String title = request.getParameter("jobTitle");
        user.setJobTitle(JobTitle.valueOf(title));
        userService.save(user);
        return "info";
    }
}
