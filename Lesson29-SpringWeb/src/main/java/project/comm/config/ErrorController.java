package project.comm.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import project.comm.exceptions.MissingUserInputException;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(MissingUserInputException.class)
    public String catchException(MissingUserInputException exception){
        return "error";
    }
}
