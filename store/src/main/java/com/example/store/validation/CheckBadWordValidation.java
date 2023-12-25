package com.example.store.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
@Constraint(validatedBy = BadWordValidator.class)
public @interface CheckBadWordValidation {
    String message() default "was used incorrect word";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
