package abstractFabric;

import abstractFabric.service.orcImpl.OrcAbstractFabric;
import abstractFabric.utils.CreatureProcess;
import abstractFabric.service.elfImpl.ElfAbstractFabric;

public class AbstractFabricMain {
    public static void main(String[] args) {
        CreatureProcess.showCreatureInfo(new ElfAbstractFabric());
        CreatureProcess.showCreatureInfo(new OrcAbstractFabric());
    }
}
