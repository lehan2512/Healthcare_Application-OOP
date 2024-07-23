import java.util.Date;

public class GeneralAppointment extends Appointment{
    private String patientNotes;

    public GeneralAppointment(Doctor doctor, Patient patient, Date appointmentDate, int appointmentTime, String patientNotes){
        super(doctor, patient, appointmentDate, appointmentTime);
        this.patientNotes = patientNotes;
    }

    public String getPatientNotes(){
        return patientNotes;
    }
}
