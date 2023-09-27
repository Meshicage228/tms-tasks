package abstractFabric.service.orcImpl;

import abstractFabric.service.CommunicationService;

public class OrcCommunicationImpl implements CommunicationService {
    @Override
    public void saySmth() {
        System.out.println("Raaarrh");
    }
}
