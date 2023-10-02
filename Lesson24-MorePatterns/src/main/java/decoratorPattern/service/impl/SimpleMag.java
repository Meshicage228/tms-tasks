package decoratorPattern.service.impl;

import decoratorPattern.service.Magician;

public class SimpleMag implements Magician {
    @Override
    public void attack() {
        System.out.println("Magician attacks you!");
    }

    @Override
    public void showPossibilities() {
        System.out.println("Can cast : fireball");
    }

    @Override
    public void castSpell() {
        System.out.println("Casts fireball");
    }
}
