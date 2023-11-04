package thisProject.example.web.controllers;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import thisProject.example.exceptions.MissingRegistrationInputException;

@ControllerAdvice
public class RegistrationErrorController {
    @ExceptionHandler(MissingRegistrationInputException.class)
    public String printErrors(MissingRegistrationInputException exception){
        return "mainHomePage";
    }
}
