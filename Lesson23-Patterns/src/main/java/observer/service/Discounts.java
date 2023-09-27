package observer.service;

import lombok.Getter;

@Getter
public enum Discounts {
    LITTLE_DISCOUNT(2),
    MIDDLE_DISCOUNT(10),
    HUGE_DISCOUNT(30);

    Discounts(int percentDiscount) {
        this.percentDiscount = percentDiscount;
    }
    private int percentDiscount;
}
