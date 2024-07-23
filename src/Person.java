abstract class Person {
    private String ID;
    private String name;
    private String contactNumber;

    public Person(String ID, String name, String contactNumber) {
        this.ID = ID;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public String getContactNumber() { return contactNumber;}
}
