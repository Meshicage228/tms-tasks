package com.example.store.validation;

import com.example.store.exception.BadWordException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class BadWordValidator implements ConstraintValidator<CheckBadWordValidation, String> {
    private List<String> badWords = List.of("broken", "expensive", "scratched");
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return wordExists(value, context);
    }
    private boolean wordExists(String value, ConstraintValidatorContext context) throws BadWordException{
        if(value.isBlank()){
            throw new BadWordException("Empty string!", 400);
        }
        String[] s = value.trim().split(" |\\,");
        for(String str : s){
            if(badWords.contains(str.toLowerCase())){
                return false;
            }
        }
        return true;
    }
}
