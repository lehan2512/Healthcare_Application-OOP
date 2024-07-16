public class Patient {
    private
    String ID; // T or D in front, followed by '-' and a number. Eg: T-0034
    String Name;
    String dateOfBirth;
    String contactNumber;
    String gender;

    public
    Patient(String ID, String Name, String dateOfBirth, String contactNumber, String gender) {
        this.ID = ID;
        this.Name = Name;
        this.dateOfBirth = dateOfBirth;
        this.contactNumber = contactNumber;
        this.gender = gender;
    }

    char getPatientType()
    {
        return ID.charAt(0);
    }
    String getID() {
        return ID;
    }
    String getName() {
        return Name;
    }
    String getDateOfBirth() {
        return dateOfBirth;
    }
    String getContactNumber() {
        return contactNumber;
    }
    String getGender() { return gender; }

    void setID(String ID) {
        this.ID = ID;
    }
    void setName(String Name) {
        this.Name = Name;
    }
    void setDateOfBirth(String Birthday) {
        this.dateOfBirth = Birthday;
    }
    void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    void setGender(String gender) { this.gender = gender; }
}
