package comm.tms.Hometask.additional.object;

import comm.tms.Hometask.additional.service.Doctor;

public class Dantist implements Doctor {
    @Override
    public void heal() {
        System.out.println("Dantist will help");
    }
}
