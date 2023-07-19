package comm.tms.Hometask.additional.object;

import comm.tms.Hometask.additional.service.Doctor;

public class Surgeon implements Doctor {
    @Override
    public void heal() {
        System.out.println("Surgeon will help");
    }
}
