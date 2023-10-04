package abstractFabric.service.elfImpl;

import abstractFabric.service.MoveService;

public class ElfMoveImpl implements MoveService {
    @Override
    public void makeStep() {
        System.out.println("Elf very fast");
    }
}
