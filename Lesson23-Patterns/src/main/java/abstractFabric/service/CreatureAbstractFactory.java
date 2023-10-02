package abstractFabric.service;

public interface CreatureAbstractFactory {
    CastSpellService castSpell();
    CommunicationService communicate();
    MoveService moves();
}
