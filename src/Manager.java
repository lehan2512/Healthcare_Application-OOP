import java.util.Date;
import java.util.HashMap;

public class Manager {
    private HashMap<String, Doctor> doctorMap = new HashMap<>();
    private HashMap<String, Patient> patientMap = new HashMap<>();

    public Manager () {};

    public void createDummyData(){

        // Dummy Doctors
        Doctor doc1 = new Doctor("001", "Ranasinghe", "Dermatology","0714658798");
        Doctor doc2 = new Doctor("002", "Dehan", "Oncology","0714658798");
        Doctor doc3 = new Doctor("003", "Rasnayake", "Thoracology","0714658798");
        Doctor doc4 = new Doctor("004", "Balasooriya", "Anesthesia","0714658798");

        Date thaththi = new Date(68,8,10);
        Date amma = new Date(70,2,15);
        Date aiya = new Date(99,11,25);
        Date me = new Date(102,8,25);
        doc1.addAvailability(thaththi);
        doc1.addAvailability(amma);
        doc1.addAvailability(aiya);
        doc1.addAvailability(me);

        getDoctorMap().put("001", doc1);
        getDoctorMap().put("002", doc2);
        getDoctorMap().put("003", doc3);
        getDoctorMap().put("004", doc4);

        // Dummy Patients
        Patient patient1 = new Patient("T-001", "Lando Norris", "2003-07-27","0714658798","m");
        Patient patient2 = new Patient("D-001", "Macy Verstappan", "1999-04-15","0714658798","f");
        Patient patient3 = new Patient("T-002", "Charles Leclerc", "1998-09-06","0714658798","m");
        Patient patient4 = new Patient("D-002", "Carolina Sainz", "2001-02-18","0714658798","f");

        getPatientMap().put("T-001", patient1);
        getPatientMap().put("D-001", patient2);
        getPatientMap().put("T-002", patient3);
        getPatientMap().put("D-002", patient4);
    }

    public HashMap<String, Doctor> getDoctorMap(){
        return doctorMap;
    }

    public void addDoctor(){
        Input input = new Input();
        System.out.println("Creating Doctor Profile\n");
        Doctor newDoctor = input.newDoctor(getDoctorMap());
        if (newDoctor == null) {
            System.out.println("Cancelled");
            return;
        }
        String newDoctorID = newDoctor.getID();

        getDoctorMap().put(newDoctorID, newDoctor);
        System.out.println("Added new doctor");
    }

    public Doctor getDoctor(){
        Input input = new Input();
        String doctorID = input.checkDoctorExistance(doctorMap);
        return doctorMap.get(doctorID);
    }

    public boolean doctorExists(String doctorID){
        return getDoctorMap().containsKey(doctorID);
    }

    public void addDoctorAvailability(){
        Input input = new Input();
        Date availableDate;
        Doctor doctor = this.getDoctor();
        availableDate = input.newDoctorAvailability(doctor);
        if (availableDate == null || doctor == null) {
            System.out.println("Cancelled");
        }
        else {
            doctor.addAvailability(availableDate);
            System.out.println("Added Doctor Availability");
        }
    }

    public HashMap<String, Patient> getPatientMap(){
        return patientMap;
    }

    public void addNewPatient(){

        Input input = new Input();
        System.out.println("Creating Patient Profile\n");
        Patient newPatient = input.newPatient();
        if (newPatient == null) {
            System.out.println("Cancelled");
            return;
        }
        String newPatientID = newPatient.getID();

        getPatientMap().put(newPatientID, newPatient);
        System.out.println("Added new patient");
    }

    public Patient getPatient(){
        Input input = new Input();
        String patientID = input.checkPatientExistance(patientMap);
        return patientMap.get(patientID);
    }

    public void bookAppointment(){
        Input input = new Input();
        Doctor doctor = this.getDoctor();
        Patient patient = this.getPatient();
        if (patient == null || doctor == null) {
            System.out.println("Booking cancelled");
            return;
        }
        Appointment appointment = input.newAppointment(patient, doctor);
        if(appointment == null){
            System.out.println("Booking cancelled");
            return;
        }

        Doctor selectedDoctor = appointment.getDoctor();
        Date appointmentDate = appointment.getDate();
        selectedDoctor.addAppointment(appointmentDate, appointment);
        System.out.println("Appointment Booked\n");
    }
}
