package com.example.store.exception.handler;

import com.example.store.exception.BadWordException;
import com.example.store.exception.CarGetIdException;
import com.example.store.exception.details.BadWordExceptionDetails;
import com.example.store.exception.details.ExceptionDetails;
import org.springframework.http.HttpStatus;
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
    @ExceptionHandler(BadWordException.class)
    public ResponseEntity<BadWordExceptionDetails> getBad(BadWordException ex){
        String message = ex.getMessage();
        Integer code = ex.getCode();

        BadWordExceptionDetails except = BadWordExceptionDetails.builder()
                .message(message)
                .code(code)
                .build();

        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(except);
    }

}
