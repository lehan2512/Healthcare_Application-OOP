import java.sql.Time;
import java.util.Date;

abstract class Appointment {
    private Doctor doctor;
    private Patient patient;
    private Date date;
    private int time;

    public Appointment(Doctor doctor, Patient patient, Date date, int time) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.time = time;
    }

    public Doctor getDoctor() {
        return doctor;
    }
    public Patient getPatient() {return patient;}
    public Date getDate() {
        return date;
    }
    public int getTime() {
        return time;
    }
}
