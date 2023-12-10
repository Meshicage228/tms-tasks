package com.example.cars.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExceptionDetails {
    private String serviceName;
    private String message;
    private Integer code;
}
