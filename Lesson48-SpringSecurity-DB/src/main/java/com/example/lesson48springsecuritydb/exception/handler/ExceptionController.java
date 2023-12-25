package com.example.lesson48springsecuritydb.exception.handler;

import com.example.lesson48springsecuritydb.exception.NotUniqueUsernameException;
import com.example.lesson48springsecuritydb.exception.description.UsernameExceptionDescription;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotUniqueUsernameException.class)
    public ResponseEntity<UsernameExceptionDescription> catchException(NotUniqueUsernameException ex){

        UsernameExceptionDescription build = UsernameExceptionDescription.builder()
                .message(ex.getMessage())
                .build();

        return ResponseEntity.status(400)
                .body(build);
    }
}
