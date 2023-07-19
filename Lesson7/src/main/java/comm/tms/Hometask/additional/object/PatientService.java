package comm.tms.Hometask.additional.object;

import comm.tms.Hometask.additional.service.Doctor;

public abstract class PatientService {
    public static void AppointDoctor(Patient patient) {
        switch (patient.getMethodOfTherapy()) {
            case CODE1: {
                patient.addDoctorToArray(new Surgeon());
                break;
            }
            case CODE2: {
                patient.addDoctorToArray(new Dantist());
                break;
            }
            default: {
                patient.addDoctorToArray(new Therapist());
            }
        }
    }

    public static void showHealMethod(Patient patient) {
        if (patient.getDoctors().length == 0) {
            System.out.println("No doctors added !");
            return;
        }
        for (Doctor doc : patient.getDoctors()) {
            if (doc != null) {
                doc.heal();
            }
        }
    }
}
