import java.util.Collections;
import java.util.Map;
import java.util.Date;
import java.text.SimpleDateFormat;

public class UserInterface {

    public void displayApplication(Manager manager){
        mainMenu(manager);
    }

    private void mainMenu(Manager manager){
        Input input = new Input();
        int mainMenuSelection = 0;

        while (mainMenuSelection != 3) {

            System.out.println("\nMAIN MENU" +
                    "\nIf you are a hospital administrator, please press 1" +
                    "\nIf you are a patient, please press 2" +
                    "\nPress 3 to exit");
            mainMenuSelection = input.mainMenu();

            switch (mainMenuSelection) {
                case 1:
                    administratorMenu(manager);
                    break;
                case 2:
                    patientMenu(manager);
                    break;
                case 3:
                    System.out.println("Exit program");
                    break;
            }
        }
    }

    private void administratorMenu(Manager manager){
        Input adminInput = new Input();
        int adminMenuSelection = 0;

        while (adminMenuSelection != 3) {
            System.out.println("\nAdministrator Menu"
                    + "\nPress 1 to add a doctor"
                    + "\nPress 2 to add a doctor availability"
                    + "\nPress 3 to exit");
            adminMenuSelection = adminInput.adminMenu();

            if (adminMenuSelection == 1) {
                manager.addDoctor();
            } else if (adminMenuSelection == 2) {
                manager.addDoctorAvailability();
            } else {
                System.out.println("Exit to main menu");
            }
        }
    }

    private void patientMenu(Manager manager){
        Input patientInput = new Input();
        int patientMenuSelection = 0;

        while (patientMenuSelection != 5) {
            System.out.println("\nPatient Menu"
                    + "\nPress 1 to view all doctors"
                    + "\nPress 2 to book an appointment"
                    + "\nPress 3 view a selected doctor's bookings"
                    + "\nPress 4 to register a patient"
                    + "\nPress 5 to exit");
            patientMenuSelection = patientInput.patientMenu();

            if (patientMenuSelection == 1) {
                displayAllDoctors(manager);
            } else if (patientMenuSelection == 2) {
                manager.bookAppointment();
            } else if (patientMenuSelection == 3) {
                System.out.println("Selected to view a doctor's bookings");
            } else if (patientMenuSelection == 4) {
                manager.addNewPatient();
            } else {
                System.out.println("Exited to main menu");
            }
        }
    }

    private void displayAllDoctors(Manager manager){
        System.out.println("\nAll available doctors");
        // Creating a table to display doctors
        // Define the table column widths
        int idWidth = 10;
        int nameWidth = 20;
        int specializationWidth = 20;

        // Print the table header
        System.out.printf("%-" + idWidth + "s%-" + nameWidth + "s%-" + specializationWidth + "s%n", "ID", "Name", "Specialization");
        System.out.println(String.join("", Collections.nCopies(idWidth + nameWidth + specializationWidth, "-")));

        // Print the table rows
        for (Map.Entry<String, Doctor> entry : manager.getDoctorMap().entrySet()) {
            Doctor doctor = entry.getValue();
            System.out.printf("%-" + idWidth + "s%-" + nameWidth + "s%-" + specializationWidth + "s%n", doctor.getID(), doctor.getName(), doctor.getSpecialization());
        }
    }

    static void displayDoctorAvailability(Doctor doctor){
        Input input = new Input();
        System.out.println("\nDoctor name: " + doctor.getName());

        System.out.println("Availabilities:");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (Date date : doctor.getAvailabilityList()) {
            String formattedDate = dateFormat.format(date);
            System.out.println(formattedDate);
        }
        if (doctor.getAvailabilityList().isEmpty()) {
            System.out.println("(Doctor not available)\n");
        }
    }
}
