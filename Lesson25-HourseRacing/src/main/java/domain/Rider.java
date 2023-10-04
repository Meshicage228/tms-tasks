package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
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
