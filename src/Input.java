import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    public Date date(){
        int year;
        int month;
        int day;
        System.out.println("\nEnter Date");
        System.out.println("Enter year (eg:-2024)\nOR enter '0' to exit:");
        year = this.integer();
        if (year == 0) {
            return null;
        }
        year -= 1900;
        System.out.println("Month (eg:- 7 for July)\nOR enter '0' to exit: ");
        month = this.integer();
        while((month < 0) || (month > 12)){
            System.out.println("Invalid month. Please enter a valid month.\nOR enter '0' to exit:");
            month = this.integer();
        }
        if (month == 0) {
            return null;
        }
        month --;
        System.out.println("Enter Day (eg:- 25 for the 25th)\nOR enter '0' to exit: ");
        day = this.integer();
        while(day < 0 || day > 31){
            System.out.println("Invalid day. Please enter a valid day.\nOR enter '0' to exit:");
            day = this.integer();
        }
        if (day == 0) {
            return null;
        }

        return new Date(year, month, day);
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

    public Doctor getNewDoctor(HashMap<String, Doctor> doctorMap){
        String ID = null;
        String name = null;
        String specializaton = null;
        int contactNumber;

        System.out.println("Enter Doctor ID OR enter '0' to exit: ");
        ID = this.string();
        while(doctorMap.containsKey(ID) && (!ID.equals("0"))){
            System.out.println("Doctor ID already exists. Please choose another ID\n OR enter '0' to exit: ");
            ID = this.string();
        }
        if (ID.equals("0")) {
            return null;
        }
        System.out.println("Enter Doctor Name: ");
        name = this.string();
        System.out.println("Enter Doctor's Specializaton: ");
        specializaton = this.string();
        System.out.println("Enter Doctor's Contact Number: ");
        contactNumber = this.integer();
        while (contactNumber < 110000000 || contactNumber > 999999999){
            System.out.println("Invalid number. Please enter a 10 digit contact number");
            contactNumber = this.integer();
        }

        //output doctor details before entering to database
        System.out.println("\nEntry Summery\nDoctor ID: " + ID + "\nDoctor Name: " + name + "\nSpecialization: " + specializaton + "\nContact Number: " + contactNumber);
        System.out.println("Save doctor? (Y/N)");
        if (sc.next().toLowerCase().equals("y")){
            return new Doctor(ID, name, specializaton, String.valueOf(contactNumber));
        }
        else{
            return null;
        }
    }

    public Date getNewDoctorAvailability(Doctor doctor){
        Date availableDate;
        System.out.println("Enter new available date: ");
        availableDate = this.date();

        //validating date
        if (availableDate == null) {return null;}
        for (Date date : doctor.getAvailabilityList()) {
            // Compare dates without considering the time part
            if (date.equals(availableDate)) {
                System.out.println("Doctor is already available on that date");
                return null;
            }
        }
        return availableDate;
    }

    public String checkDoctorExistance(HashMap<String, Doctor> doctorMap){
        System.out.println("Enter Doctor ID: ");
        String ID = this.string();
        // Validating patient ID
        while(doctorMap.get(ID) == null && !ID.equals("0")){
            System.out.println("Invalid Doctor ID. Enter valid Doctor ID OR Enter '0' to exit:");
            ID = this.string();
        }

        if (ID.equals("0")){
            return null;
        }
        else{
            return ID;
        }
    }

    public Patient getNewPatient(){
        String ID = null;
        String name = null;
        String dateOfBirth = null;
        int contactNumber;
        String gender = null;

        // Getting patient ID in required format
        System.out.println("Enter first letter of Patient ID- 'T' or 'D')\nEnter letter: ");
        char patientType = this.character();
        while (patientType != 'T' && patientType != 'D' && patientType != '0')
        {
            System.out.println("Invalid. Enter upper case 'T' or 'D'. Check Patient ID again\nOR enter '0' to exit: ");
            patientType = character();
        }
        if (patientType == '0'){
            return null;
        }
        System.out.println("Enter the 4 digit number in patient ID (eg- 0034)\nEnter number: ");
        int patientNumber = this.integer();
        while (patientNumber < 0 || patientNumber > 9999) {
            System.out.println("Invalid number. Enter the 4 digit number in patient ID (eg- 0034). Check patient ID again.\nOR enter '0' to exit: ");
            patientNumber = this.integer();
        }
        if (patientNumber == 0) {
            return null;
        }
        // Format the patient number to ensure it has four digits
        String patientNumberString = String.format("%04d", patientNumber);

        ID = patientType + "-" + patientNumberString;

        System.out.println("Enter Patient Name: ");
        name = string();
        System.out.println("Enter Patient's Date of Birth (DD/MM/YYYY): ");
        dateOfBirth = string();
        System.out.println("Enter Patient Contact Number: ");
        contactNumber = integer();
        while (contactNumber < 110000000 || contactNumber > 999999999){
            System.out.println("Invalid number. Please enter a 10 digit contact number");
            contactNumber = this.integer();
        }
        System.out.println("Enter Patient Gender(Enter 'm' for male / 'f' for female: ");
        gender = string();

        //Output new patient details before saving
        System.out.println("Entry Summery\nPatient ID: " + ID + "\nPatient Name: " + name + "\nPatient's Date of Birth: " + dateOfBirth + "\nPatient's Contact Number: " + contactNumber);
        System.out.println("Save patient? (Y/N)");
        if (sc.next().toLowerCase().equals("y")) {
            return new Patient(ID, name, dateOfBirth, String.valueOf(contactNumber), gender);
        }
        else {
            return null;
        }
    }

    public String checkPatientExistance(HashMap<String, Patient> patientMap){
        System.out.println("Enter Patient ID: ");
        String ID = this.string();

        // Validating patient ID
        while(patientMap.get(ID) == null && !ID.equals("0")){
            System.out.println("Invalid Patient ID. Enter valid patient ID in format 'T-001' OR Enter '0' to exit:");
            ID = this.string();
        }

        if (ID.equals("0")){
            return null;
        }
        else{
            return ID;
        }
    }

    public char getNewAppointmentType(){
        System.out.println("Select Appointment Type\n'G' for General Appointment\n'R' for Referral Appointment\nEnter Letter: ");
        char appointmentType = this.character();

        while(appointmentType != 'G' && appointmentType != 'R' && appointmentType != '0'){
            System.out.println("Invalid Appointment Type. Enter valid Appointment Type\nOR press '0' to exit");
            appointmentType = this.character();
        }
        if (appointmentType == '0'){
            return 0;
        }
        else{
            return appointmentType;
        }
    }

    public Appointment getNewAppointment (Patient patient, Doctor doctor){
        String appointmentNotes;
        Date appointmentDate;
        int appointmentTime;


        // Enter appointment details
        appointmentNotes = getAppointmentNotes();
        appointmentNotes = this.string();
        appointmentDate = getAppointmentDate(doctor);
        appointmentTime = getAppointmentTime(doctor, appointmentDate);


        // Entry Summery
        UserInterface.displayNewAppointmentSummery(doctor, patient, appointmentDate, appointmentTime, appointmentNotes);

        System.out.println("Book appointment? (Y/N): ");
        if (sc.next().toLowerCase().equals("y")) {
            return new GeneralAppointment(doctor,patient,appointmentDate, appointmentTime, appointmentNotes);
        }
        return null;
    }

    public Appointment getNewAppointment (Patient patient, Doctor doctor, Doctor referralDoctor){
        String appointmentNotes;
        Date appointmentDate;
        int appointmentTime;

        // Enter appointment details
        appointmentNotes = getAppointmentNotes();
        appointmentNotes = this.string();
        appointmentDate = getAppointmentDate(doctor);
        appointmentTime = getAppointmentTime(doctor, appointmentDate);

        // Entry Summery
        UserInterface.displayNewAppointmentSummery(doctor, patient, appointmentDate, appointmentTime, referralDoctor, appointmentNotes);

        System.out.println("Book appointment? (Y/N): ");
        if (sc.next().toLowerCase().equals("y")) {
            return new ReferralAppointment(doctor,patient,appointmentDate,appointmentTime,referralDoctor,appointmentNotes);
        }
        return null;
    }

    public String getAppointmentNotes (){
        System.out.println("Enter Appointment notes: ");
        String appointmentNotes = this.string();
        return appointmentNotes;
    }

    public Date getAppointmentDate (Doctor doctor){
        Date appointmentDate = null;

        // Display doctor availability and select an available date
        boolean dateExists = false;
        while(!dateExists){
            UserInterface.displayDoctorAvailability(doctor);
            if(doctor.getAvailabilityList().isEmpty()){
                return null;
            }

            appointmentDate = this.date();
            if (appointmentDate == null) {
                return null;
            }
            for (Date date : doctor.getAvailabilityList()) {
                // Compare dates without considering the time part
                if (date.equals(appointmentDate)) {
                    dateExists = true;
                }
            }
            if(!dateExists){
                System.out.println("Select a date from the available dates.");
            }
        }
        return appointmentDate;
    }

    public int getAppointmentTime(Doctor doctor, Date appointmentDate){
        int appointmentTime;

        ArrayList<Integer> availableSlots = new ArrayList<>();
        availableSlots.add(5);
        availableSlots.add(6);
        availableSlots.add(7);
        availableSlots.add(8);
        availableSlots.add(9);

        // Select a time for the booking
        System.out.println("Enter a time slot for the appointment");
        while (true){
            System.out.println("Available time slots: ");
            if (doctor.getCalendar().get(appointmentDate) == null) {
                System.out.println("5, 6, 7, 8, 9");
            } else {
                for (int i = 0; i < doctor.getCalendar().get(appointmentDate).size(); i++) {
                    if (doctor.getCalendar().get(appointmentDate).get(i) != null) {
                        availableSlots.set(i, null);
                    }
                }
                for (int i = 0; i < availableSlots.size(); i++) {
                    if(availableSlots.get(i) != null) {
                        System.out.println(availableSlots.get(i) + "pm ");
                    }
                }
                System.out.println("Enter time (eg:- enter '6' for 6pm): ");
            }

            appointmentTime = this.integer();
            if(appointmentTime < 5 || appointmentTime > 9){
                System.out.println("Enter a valid time slot");
            }
            else if (!availableSlots.contains(appointmentTime)) {
                System.out.println("Time slot already booked. Select a different slot");
            }
            else {
                break;
            }
        }
        return appointmentTime;
    }


    @Override
    public void close() {
        if (sc != null) {
            sc.close();
        }
    }

}
