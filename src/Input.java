import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Input implements AutoCloseable {
    private Scanner sc;

    public Input (){
        this.sc = new Scanner(System.in);
    }

    public char character(){
        return sc.next().charAt(0);
    }

    public int integer(){
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            sc.next(); // Clear the invalid input
        }
        int value = sc.nextInt();
        sc.nextLine(); // Consume the newline left-over
        return value;
    }
    public String string(){
        return sc.nextLine();
    }
    public double doubleValue() {
        while (!sc.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a decimal value.");
            sc.next(); // Clear the invalid input
        }
        double value = sc.nextDouble();
        sc.nextLine(); // Consume the newline left-over
        return value;
    }

    public int mainMenu(){
        int mainMenuSelection = this.integer();

        // validation of user input
        while (mainMenuSelection < 1 || mainMenuSelection > 3) {
            System.out.println("Please enter a number between 1 and 3");
            mainMenuSelection = this.integer();
        }
        return mainMenuSelection;
    }

    public int adminMenu(){
        int adminMenuSelection = this.integer();

        // validation of user input
        while (adminMenuSelection < 1 || adminMenuSelection > 3) {
            System.out.println("Please enter a number between 1 and 3");
            adminMenuSelection = this.integer();
        }
        return adminMenuSelection;
    }

    public int patientMenu(){

        int patientMenuSelection = this.integer();
        while (patientMenuSelection < 1 || patientMenuSelection > 5) {
            System.out.println("Please enter a number between 1 and 5");
            patientMenuSelection = this.integer();
        }
        return patientMenuSelection;
    }

    public Doctor newDoctor(){
        String ID = null;
        String name = null;
        String specializaton = null;
        String contactNumber = null;

        System.out.println("Enter Doctor ID: ");
        ID = this.string();
        System.out.println("Enter Doctor Name: ");
        name = this.string();
        System.out.println("Enter Doctor's Specializaton: ");
        specializaton = this.string();
        System.out.println("Enter Doctor's Contact Number: ");
        contactNumber = this.string();
        return new Doctor(ID, name, specializaton, contactNumber);
    }

    public Patient newPatient(){
        String ID = null;
        String name = null;
        String dateOfBirth = null;
        String contactNumber = null;
        String gender = null;

        // Getting patient ID in required format
        System.out.println("Enter first letter of Patient ID- 'T' or 'D')\nEnter letter: ");
        char patientType = this.character();
        while (patientType != 'T' && patientType != 'D')
        {
            System.out.println("Invalid. Enter upper case 'T' or 'D'. Check Patient ID again\n Enter Letter: ");
            patientType = character();
        }
        System.out.println("Enter the 4 digit number in patient ID (eg- 0034)\nEnter number: ");
        int patientNumber = this.integer();
        while (patientNumber < 1 || patientNumber > 9999) {
            System.out.println("Invalid number. Enter the 4 digit number in patient ID (eg- 0034). Check patient ID again.\nEnter number: ");
            patientNumber = this.integer();
        }
        // Format the patient number to ensure it has four digits
        String patientNumberString = String.format("%04d", patientNumber);

        ID = patientType + "-" + patientNumberString;

        System.out.println("Enter Patient Name: ");
        name = string();
        System.out.println("Enter Patient's Date of Birth: ");
        dateOfBirth = string();
        System.out.println("Enter Patient Contact Number: ");
        contactNumber = string();
        System.out.println("Enter Patient Gender(Enter 'm' for male / 'f' for female: ");
        gender = string();
        return new Patient(ID, name, dateOfBirth, contactNumber, gender);
    }

    public String checkDoctorExistance(HashMap<String, Doctor> doctorMap){
        System.out.println("Enter Doctor ID: ");
        String ID = this.string();
        // Validating doctor ID
        if(!Manager.searchDoctor(ID, doctorMap)){
            System.out.println("Invalid Doctor ID");
            return null;
        } else{
            return ID;
        }
    }

    public Date newDoctorAvailability(HashMap<String, Doctor> doctorMap){
        System.out.println("Enter Date\n");
        System.out.println("Enter year (eg-2024): ");
        int year = this.integer() - 1900;
        System.out.println("Month (eg- 7 for July): ");
        int month = this.integer();
        while(month < 1 || month > 12){
            System.out.println("Invalid month. Please enter a valid month.");
            month = this.integer();
        }
        month --;
        System.out.println("Enter Day (eg- 25 for the 25th): ");
        int day = this.integer();
        while(day < 1 || day > 31){
            System.out.println("Invalid day. Please enter a valid day.");
            day = this.integer();
        }

        return new Date(year, month, day);
    }

    public Doctor getDoctor(HashMap<String, Doctor> doctorMap){
        String doctorID = checkDoctorExistance(doctorMap);
        return doctorMap.get(doctorID);
    }

    @Override
    public void close() {
        if (sc != null) {
            sc.close();
        }
    }
}
