package abstractFabric.service.elfImpl;

import abstractFabric.service.CastSpellService;

public class ElfCastSpellImpl implements CastSpellService {
    @Override
    public void doSpell() {
        System.out.println("Elf shrinked");
    }
}
