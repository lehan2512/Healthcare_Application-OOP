import java.util.*;

public class Doctor extends Person{
    private String specialization;

    private ArrayList<Date> availabilityList = new ArrayList<>();
    private HashMap<Date, ArrayList<Appointment>> calendar = new HashMap<>();

    public Doctor (String ID, String name, String contactNumber, String specialization) {
        super(ID, name, contactNumber);
        this.specialization = specialization;
    }

    public boolean isPhysician(){
        return specialization.contains("Physician");
    }
    public String getSpecialization (){
        return specialization;
    }
    public void setSpecialization (String specialization){
        this.specialization = specialization;
    }
    public ArrayList<Date> getAvailabilityList (){ return availabilityList; }
    public HashMap<Date, ArrayList<Appointment>> getCalendar (){ return calendar; }

    public void addAvailability (Date availability){
        availabilityList.add(availability);
    }

    public void addAppointment(Date appointmentDate, Appointment appointment){

        //check if appointment list exists for given date in calendar
        ArrayList<Appointment> appointmentsList = calendar.get(appointmentDate);
        int timeSlot = appointment.getTime();

        // if list does not exist, create a new appointment list for date
        if (appointmentsList == null){
            appointmentsList = new ArrayList<>();
            for(int i = 0; i < 5; i++){
                appointmentsList.add(null);
            }
            appointmentsList.set(0, appointment);
            calendar.put(appointmentDate, appointmentsList);
        } // else add new appointment to list on that date
        else {
            appointmentsList.set(timeSlot - 5, appointment);
        }
    }
}
