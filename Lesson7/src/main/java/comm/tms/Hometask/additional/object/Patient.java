package comm.tms.Hometask.additional.object;

import comm.tms.Hometask.additional.service.Doctor;
import comm.tms.Hometask.additional.service.MethodOfTherapy;

public class Patient {
    private MethodOfTherapy methodOfTherapy;
    private Doctor[] doctors = new Doctor[10];

    public void addDoctorToArray(Doctor doctor) {
        for (int i = 0; i < doctors.length; i++) {
            if (doctors[i] == null) {
                doctors[i] = doctor;
                break;
            }
        }
    }

    public MethodOfTherapy getMethodOfTherapy() {
        return methodOfTherapy;
    }

    public void setMethodOfTherapy(MethodOfTherapy methodOfTherapy) {
        this.methodOfTherapy = methodOfTherapy;
    }

    public Doctor[] getDoctors() {
        return doctors;
    }

    public Patient(MethodOfTherapy methodOfTherapy) {
        this.methodOfTherapy = methodOfTherapy;
    }
}
