package decoratorPattern;

import decoratorPattern.service.Magician;
import decoratorPattern.service.impl.*;

public class DecoratorMain {
    public static void main(String[] args) {
        Magician magician = new BossMag(new MiddleMag(new SimpleMag()));

        magician.attack();
        magician.showPossibilities();
        magician.castSpell();
    }
}
