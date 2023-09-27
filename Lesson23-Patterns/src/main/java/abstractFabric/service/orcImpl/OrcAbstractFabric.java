package abstractFabric.service.orcImpl;

import abstractFabric.service.CastSpellService;
import abstractFabric.service.CommunicationService;
import abstractFabric.service.CreatureAbstractFactory;
import abstractFabric.service.MoveService;

public class OrcAbstractFabric implements CreatureAbstractFactory {
    @Override
    public CastSpellService castSpell() {
        return new OrcCastSpellImpl();
    }

    @Override
    public CommunicationService communicate() {
        return new OrcCommunicationImpl();
    }

    @Override
    public MoveService moves() {
        return new OrcMoveImpl();
    }
}
