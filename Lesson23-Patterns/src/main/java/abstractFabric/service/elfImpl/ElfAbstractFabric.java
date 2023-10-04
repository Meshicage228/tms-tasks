package abstractFabric.service.elfImpl;

import abstractFabric.service.CastSpellService;
import abstractFabric.service.CommunicationService;
import abstractFabric.service.CreatureAbstractFactory;
import abstractFabric.service.MoveService;

public class ElfAbstractFabric implements CreatureAbstractFactory {
    @Override
    public CastSpellService castSpell() {
        return new ElfCastSpellImpl();
    }

    @Override
    public CommunicationService communicate() {
        return new ElfCommunicationImpl();
    }

    @Override
    public MoveService moves() {
        return new ElfMoveImpl();
    }
}
