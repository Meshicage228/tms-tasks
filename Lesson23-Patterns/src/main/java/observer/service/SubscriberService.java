package observer.service;

import observer.domain.Product;

import java.util.Observable;
import java.util.Observer;

public class SubscriberService implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Product product){
            System.out.println("Hey hey customer, we have new product : " + product.getTitle());
            if (product.getDiscounts() != null){
                System.out.println("You can get it with " + product.getDiscounts().getPercentDiscount() + "% discount");
            }
        }
    }
}
