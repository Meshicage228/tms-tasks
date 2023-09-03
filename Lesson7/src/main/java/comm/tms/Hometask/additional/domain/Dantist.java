package comm.tms.Hometask.additional.domain;

import comm.tms.Hometask.additional.service.Doctor;

public class Dantist implements Doctor {
    @Override
    public void heal() {
        System.out.println("Dantist will help");
    }
}
