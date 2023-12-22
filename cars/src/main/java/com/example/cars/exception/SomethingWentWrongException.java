package com.example.cars.exception;

public class SomethingWentWrongException extends RuntimeException{
    private String message;

    public SomethingWentWrongException(String message) {
        super(message);
        this.message = message;
    }
}
