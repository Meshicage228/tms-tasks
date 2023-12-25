package com.example.cars.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StoreExceptionHandler {
    @ExceptionHandler(CarGetIdException.class)
    public ResponseEntity<ExceptionDetails> catchException(CarGetIdException ex){
        String message = ex.getMessage();
        ExceptionDetails excep = ExceptionDetails.builder()
                .serviceName("car-service")
                .message(message)
                .code(400)
                .build();
        return ResponseEntity
                .status(400)
                .body(excep);
    }
}
