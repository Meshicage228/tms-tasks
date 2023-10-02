package observer.domain;

import lombok.Builder;
import lombok.Getter;
import observer.service.Discounts;

@Getter
@Builder
public class Product {
    private String title;
    private Discounts discounts;
}
