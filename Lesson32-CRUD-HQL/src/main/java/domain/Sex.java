package domain;

import lombok.Getter;

@Getter
public enum Sex {
    MAN("M"),
    WOMAN("W");
    private String sex;

    Sex(String sex) {
        this.sex = sex;
    }
}
