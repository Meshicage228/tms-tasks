package project.comm.userService;

import org.springframework.core.convert.converter.Converter;
import project.comm.domain.JobTitle;

public class PostConverter implements Converter<String, JobTitle> {
    @Override
    public JobTitle convert(String source) {
        try {
            return JobTitle.valueOf(source);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
}
