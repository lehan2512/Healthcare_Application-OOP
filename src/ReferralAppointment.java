import java.util.Date;

public class ReferralAppointment extends Appointment{
    private Doctor referralDoctor;
    private String referralDoctorNotes;
    private String patientNotes;

    public ReferralAppointment(Doctor doctor, Patient patient, Date appointmentDate, int appointmentTime, Doctor referralDoctor, String patientNotes){
        super(doctor, patient, appointmentDate, appointmentTime);
        this.referralDoctor = referralDoctor;
        this.patientNotes = patientNotes;
    }

    public Doctor getReferralDoctor() {
        return referralDoctor;
    }
    public String getReferralDoctorNotes() {
        return referralDoctorNotes;
    }
    public String getPatientNotes() {
        return patientNotes;
    }

    public void setReferralDoctorNotes(String referralDoctorNotes) {
        this.referralDoctorNotes = referralDoctorNotes;
    }
}
