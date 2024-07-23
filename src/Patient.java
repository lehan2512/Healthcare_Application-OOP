public class Patient {
    private
    String ID; // T or D in front, followed by '-' and a number. Eg: T-0034
    String Name;
    String dateOfBirth;
    String contactNumber;
    String gender;

    public Patient(String ID, String Name, String dateOfBirth, String contactNumber, String gender) {
        this.ID = ID;
        this.Name = Name;
        this.dateOfBirth = dateOfBirth;
        this.contactNumber = contactNumber;
        this.gender = gender;
    }

    public char getPatientType()
    {
        return ID.charAt(0);
    }
    public String getID() {
        return ID;
    }
    public String getName() {
        return Name;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public String getGender() { return gender; }

    public void setID(String ID) {
        this.ID = ID;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public void setDateOfBirth(String Birthday) {
        this.dateOfBirth = Birthday;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public void setGender(String gender) { this.gender = gender; }
}
