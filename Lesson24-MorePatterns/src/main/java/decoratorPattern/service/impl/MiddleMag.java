package decoratorPattern.service.impl;

import decoratorPattern.service.Magician;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MiddleMag implements Magician {
    private Magician magician;

    @Override
    public void attack() {
        magician.attack();
    }

    @Override
    public void showPossibilities() {
        magician.showPossibilities();
        System.out.println("Can cast firewall");
        System.out.println("Can cast clone");
    }

    @Override
    public void castSpell() {
        magician.castSpell();
        System.out.println("Casts clone");
    }
}
