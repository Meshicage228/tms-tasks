package project.comm.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.comm.domain.JobTitle;
import project.comm.userService.UserService;
import project.comm.domain.User;
import project.comm.exceptions.MissingUserInputException;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/info")
@RequiredArgsConstructor
public class InfoController {
    private final UserService userService;
    @GetMapping
    public String showInfoPage(){
        return "/infoPage";
    }


    // КАК МНЕ ЗАСЕТАТЬ С UI БЕЗ РЕКВЕСТА ЕНАМ В ЮЗЕРА?
    @PostMapping
    public String addUser(User user, HttpServletRequest request){
        String title = request.getParameter("jobTitle");
        user.setJobTitle(JobTitle.valueOf(title));
        System.out.println(user);
        userService.save(user);
        return "/infoPage";
    }
}
