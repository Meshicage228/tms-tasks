package domain;

import lombok.*;

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
