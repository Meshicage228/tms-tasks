package abstractFabric.utils;

import abstractFabric.service.CreatureAbstractFactory;

public class CreatureProcess {
    public static void showCreatureInfo(CreatureAbstractFactory creatureAbstractFactory){
        creatureAbstractFactory.castSpell().doSpell();
        creatureAbstractFactory.communicate().saySmth();
        creatureAbstractFactory.moves().makeStep();
    }
}
