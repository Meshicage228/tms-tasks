package comm.tms.Hometask.additional.object;

import comm.tms.Hometask.additional.service.Doctor;

public class Therapist implements Doctor {
    @Override
    public void heal() {
        System.out.println("Therapist will help");
    }
}
