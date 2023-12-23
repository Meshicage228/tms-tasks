package com.example.store.exception.details;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String exceptionMessage;
    private String action;
    private Integer code;
}
