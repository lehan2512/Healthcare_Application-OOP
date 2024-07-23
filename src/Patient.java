public class Patient extends Person {
    private
    String dateOfBirth;
    String gender;

    public Patient(String ID, String Name, String contactNumber, String dateOfBirth, String gender) {
        super(ID, Name, contactNumber);
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public char getPatientType()
    {
        return getID().charAt(0);
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public String getGender() { return gender; }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setGender(String gender) { this.gender = gender; }
}
