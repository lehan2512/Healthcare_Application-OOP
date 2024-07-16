import java.util.Date;
import java.util.HashMap;

public class Manager {
    private HashMap<String, Doctor> doctorMap = new HashMap<>();
    private HashMap<String, Patient> patientMap = new HashMap<>();

    public Manager () {};

    public void createDummyData(){
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
    }
    public HashMap<String, Doctor> getDoctorMap(){
        return doctorMap;
    }

    public HashMap<String, Patient> getPatientMap(){
        return patientMap;
    }

    public void addNewDoctor(){
        Input input = new Input();
        System.out.println("Creating Doctor Profile\n");
        Doctor newDoctor = input.newDoctor();
        String newDoctorID = newDoctor.getID();

        getDoctorMap().put(newDoctorID, newDoctor);
    }

    static boolean searchDoctor(String doctorID, HashMap<String, Doctor> doctorMap){
        String searchId = doctorID;
        Doctor foundDoctor = doctorMap.get(searchId);
        return (foundDoctor != null);
    }

    public void addDoctorAvailability(){
        Input input = new Input();
        String doctorID = input.checkDoctorExistance(getDoctorMap());
        if (doctorID != null){
            Doctor doctor = input.getDoctor(getDoctorMap());
            doctor.addAvailability(input.newDoctorAvailability(getDoctorMap()));
        }
    }

    public void addNewPatient(){

        Input input = new Input();
        System.out.println("Creating Patient Profile\n");
        Patient newPatient = input.newPatient();
        String newPatientID = newPatient.getID();

        getPatientMap().put(newPatientID, newPatient);
    }
}
