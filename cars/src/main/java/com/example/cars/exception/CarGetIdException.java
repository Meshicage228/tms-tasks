package com.example.cars.exception;

import lombok.Getter;

@Getter
public class CarGetIdException extends RuntimeException {
    private final String message;

    public CarGetIdException(String message) {
        this.message = message;
    }
}
