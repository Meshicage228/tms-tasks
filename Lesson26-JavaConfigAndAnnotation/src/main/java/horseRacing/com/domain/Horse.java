package horseRacing.com.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Horse {
    @NonNull
    private String name;
    private double koefOfSpeed = 0;

    @Override
    public String toString() {
        return " name ='" + name + '\'';
    }
}
