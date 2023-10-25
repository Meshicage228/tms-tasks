package project.com.domain;

import lombok.Getter;

@Getter
public enum Sex {
    WOMAN('W'),
    MAN('M');

    private Character option;

    Sex(Character option) {
        this.option = option;
    }

}
