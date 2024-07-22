import java.sql.Time;
import java.util.Date;

public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String notes;
    private Date date;
    private String time;

    public Appointment(Doctor doctor, Patient patient, String notes, Date date, String time) {
        this.doctor = doctor;
        this.patient = patient;
        this.notes = notes;
        this.date = date;
        this.time = time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Date getDate() {
        return date;
    }
}
