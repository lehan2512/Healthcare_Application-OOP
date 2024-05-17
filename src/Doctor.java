public class Doctor {
    private
    String ID;
    String name;
    String birthday;
    String specialization;
    String contactNumber;

    public
    Doctor(String ID, String name, String birthday, String specialization, String contactNumber) {
        this.ID = ID;
        this.name = name;
        this.birthday = birthday;
        this.specialization = specialization;
        this.contactNumber = contactNumber;
    }

    boolean isPhysician(){
        return specialization.contains("Physician");
    }
    String getID (){
        return ID;
    }
    String getName (){
        return name;
    }
    String getBirthday (){
        return birthday;
    }
    String getSpecialization (){
        return specialization;
    }
    String getContactNumber (){
        return contactNumber;
    }
    void setID (String ID){
        this.ID = ID;
    }
    void setName (String name){
        this.name = name;
    }
    void setBirthday (String birthday){
        this.birthday = birthday;
    }
    void setSpecialization (String specialization){
        this.specialization = specialization;
    }
    void setContactNumber (String contactNumber){
        this.contactNumber = contactNumber;
    }
}
