import java.util.*;

public class Doctor {
    private String ID;
    private String name;
    private String specialization; //  Pass specialization as Neruophysician, Neurologist etc
    private String contactNumber;
    private ArrayList<Date> availabilityList = new ArrayList<>();

    public
    Doctor(String ID, String name, String specialization, String contactNumber) {
        this.ID = ID;
        this.name = name;
        this.specialization = specialization;
        this.contactNumber = contactNumber;
    }

    public boolean isPhysician(){
        return specialization.contains("Physician");
    }
    public String getID (){
        return ID;
    }
    public String getName (){
        return name;
    }
    public String getSpecialization (){
        return specialization;
    }
    public String getContactNumber (){
        return contactNumber;
    }
    public void setID (String ID){
        this.ID = ID;
    }
    public void setName (String name){
        this.name = name;
    }
    public void setSpecialization (String specialization){
        this.specialization = specialization;
    }
    public void setContactNumber (String contactNumber){
        this.contactNumber = contactNumber;
    }
    public ArrayList<Date> getAvailabilityList (){ return availabilityList; }
    public void dsplayInfo(){
        System.out.println("ID: " + this.ID + "Name: " + this.name + "Specialization: " + this.specialization + "ContactNumber: " + this.contactNumber);
    }
    public void addAvailability (Date availability){
        availabilityList.add(availability);
    }

    public void viewAvailability(){

    }

}
