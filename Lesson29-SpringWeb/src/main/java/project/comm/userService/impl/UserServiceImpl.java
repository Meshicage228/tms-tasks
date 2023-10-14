package project.comm.userService.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import project.comm.domain.JobTitle;
import project.comm.domain.User;
import project.comm.exceptions.MissingUserInputException;
import project.comm.userService.UserService;

@Component
public class UserServiceImpl implements UserService {
    @Override
    public void save(User user) {
        if(user.getName().isBlank()){
            throw new MissingUserInputException();
        }
        else if(user.getPassword().isBlank()){
            throw new MissingUserInputException();
        }
        else if(user.getEmail().isBlank()){
            throw new MissingUserInputException();
        }
    }

    @Override
    public void showUser(User user){
    }

    @ExceptionHandler(MissingUserInputException.class)
    public String catchException(MissingUserInputException exception){
        return "error";
    }
}
