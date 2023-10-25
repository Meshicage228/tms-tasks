package converters;


import domain.Sex;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class SexConverter implements AttributeConverter<Sex, String> {
    @Override
    public String convertToDatabaseColumn(Sex attribute) {
        return attribute == null ? null : attribute.getSex();
    }

    @Override
    public Sex convertToEntityAttribute(String dbData) {
        return dbData == null ? null : Sex.valueOf(dbData);
    }
}
