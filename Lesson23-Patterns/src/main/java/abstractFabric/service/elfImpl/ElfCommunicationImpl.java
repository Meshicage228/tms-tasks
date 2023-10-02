package abstractFabric.service.elfImpl;

import abstractFabric.service.CommunicationService;

public class ElfCommunicationImpl implements CommunicationService {
    @Override
    public void saySmth() {
        System.out.println("Elf language");
    }
}
