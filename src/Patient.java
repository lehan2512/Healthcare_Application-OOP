public class Patient {
    private
    String ID;
    String Name;
    String Birthday;
    String contactNumber;

    public
    Patient(String ID, String Name, String Birthday, String contactNumber) {
        this.ID = ID;
        this.Name = Name;
        this.Birthday = Birthday;
        this.contactNumber = contactNumber;
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
    String getBirthday() {
        return Birthday;
    }
    String getContactNumber() {
        return contactNumber;
    }

    void setID(String ID) {
        this.ID = ID;
    }
    void setName(String Name) {
        this.Name = Name;
    }
    void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }
    void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
