package abstractFabric.service.orcImpl;

import abstractFabric.service.CastSpellService;

public class OrcCastSpellImpl implements CastSpellService {
    @Override
    public void doSpell() {
        System.out.println("Orc stunned with a clap");
    }

}
