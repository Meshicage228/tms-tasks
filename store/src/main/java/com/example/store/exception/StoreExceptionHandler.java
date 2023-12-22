package com.example.store.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StoreExceptionHandler {
    @ExceptionHandler(CarGetIdException.class)
    public ResponseEntity<ExceptionDetails> getExc(CarGetIdException ex){
        String message = ex.getExceptionMessage();
        String serviceName = ex.getServiceName();
        Integer code = ex.getCode();

        ExceptionDetails excep = ExceptionDetails.builder()
                .serviceName(serviceName)
                .exceptionMessage(message)
                .code(code)
                .action("get car by id")
                .build();

        return ResponseEntity
                .status(code)
                .body(excep);
    }
}
