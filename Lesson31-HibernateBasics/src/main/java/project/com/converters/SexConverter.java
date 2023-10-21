package project.com.converters;

import project.com.domain.JobTitle;
import project.com.domain.Sex;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class SexConverter implements AttributeConverter<Sex, Character> {
    @Override
    public Character convertToDatabaseColumn(Sex attribute) {
        return attribute == null ? null : attribute.getOption();
    }

    @Override
    public Sex convertToEntityAttribute(Character dbData) {
        switch (dbData){
            case 'M' -> {
                return Sex.MAN;
            }
            case 'W' -> {
                return Sex.WOMAN;
            }
        }
        return null;
    };
}
