package horseRacing.com.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Rider {
    private String name;

    @Override
    public String toString() {
        return " name ='" + name + '\'';
    }
}
