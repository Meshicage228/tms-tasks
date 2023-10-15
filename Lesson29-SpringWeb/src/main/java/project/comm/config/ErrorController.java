package project.comm.config;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import project.comm.exceptions.MissingUserInputException;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(MissingUserInputException.class)
    public String catchException(MissingUserInputException exception){
        return "error";
    }
}
