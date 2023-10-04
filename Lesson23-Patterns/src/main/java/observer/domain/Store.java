package observer.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

@Getter
public class Store extends Observable {
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
        setChanged();
        notifyObservers(product);
    }

}
