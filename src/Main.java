import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input1 = 0;

        while (input1 != 3) {
            // Main menu options
            System.out.println("\nMAIN MENU" +
                    "\nIf you are a hospital administrator, please press 1" +
                    "\nIf you are a patient, please press 2" +
                    "\nPress 3 to exit");
            input1 = scanner.nextInt();

            // validation of user input
            while (input1 < 1 || input1 > 3) {
                System.out.println("Please enter a number between 1 and 3");
                input1 = scanner.nextInt();
            }

            switch (input1) {
                case 1:
                    administratorMenu();
                    break;
                case 2:
                    patientMenu();
                    break;
                case 3:
                    System.out.println("Exit program");
                    break;
            }
        }
    }

    static void administratorMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAdministrator Menu"
                + "\nPress 1 to add a doctor"
                + "\nPress 2 to add a doctor availability"
                + "\nPress 3 to exit");
        int input2 = scanner.nextInt();
        while (input2 < 1 || input2 > 3) {
            System.out.println("Please enter a number between 1 and 3");
            input2 = scanner.nextInt();
        }

        if (input2 == 1) {
            System.out.println("Selected to add doctor");
        }
        else if (input2 == 2) {
            System.out.println("Selected to add doctor availability");
        }
        else {
            System.out.println("Exit to main menu");
        }
    }

    static void patientMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPatient Menu"
                + "\nPress 1 to view a doctor"
                + "\nPress 2 to book an appointment"
                + "\nPress 3 view a selected doctor's bookings"
                + "\nPress 4 to register a patient"
                + "\nPress 5 to exit");

        int input3 = scanner.nextInt();
        while (input3 < 1 || input3 > 5) {
            System.out.println("Please enter a number between 1 and 5");
            input3 = scanner.nextInt();
        }

        if (input3 == 1) {
            System.out.println("Selected to view a doctor");
        }
        else if (input3 == 2) {
            System.out.println("Selected to view a doctor availability");
        }
        else if (input3 == 3) {
            System.out.println("Selected to view a doctor's bookings");
        }
        else if (input3 == 4) {
            System.out.println("Selected to register a patient");
        }
        else{
            System.out.println("Exited to main menu");
        }
    }
}