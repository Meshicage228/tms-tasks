package templateMethod;

import templateMethod.domain.Car;
import templateMethod.service.impl.AlexAsDriver;
import templateMethod.service.impl.VladAsDriver;

public class TemplateMain {
    public static void main(String[] args) {
        Car car = new Car(new VladAsDriver());
        car.carStatistics();

        car.changeBehaviour(new AlexAsDriver());
        car.carStatistics();
    }
}
