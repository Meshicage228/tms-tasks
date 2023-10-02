package observer;

import observer.domain.Product;
import observer.domain.Store;
import observer.service.Discounts;
import observer.service.SubscriberService;

public class ObserverMain {
    public static void main(String[] args) {
        Store store = new Store();

        Product product1 = Product.builder()
                .title("Milk")
                .discounts(Discounts.LITTLE_DISCOUNT)
                .build();

        Product product2 = Product.builder()
                .title("ChesseNavarro")
                .discounts(Discounts.HUGE_DISCOUNT)
                .build();

        Product product3 = Product.builder()
                .title("Orange")
                .build();

        var subscriberService = new SubscriberService();

        store.addObserver(subscriberService);

        store.addProduct(product1);
        store.addProduct(product2);
        store.addProduct(product3);

    }
}
