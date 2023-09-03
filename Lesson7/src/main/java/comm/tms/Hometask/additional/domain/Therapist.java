package comm.tms.Hometask.additional.domain;

import comm.tms.Hometask.additional.service.Doctor;

public class Therapist implements Doctor {
    @Override
    public void heal() {
        System.out.println("Therapist will help");
    }
}
