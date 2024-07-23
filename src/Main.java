public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager();
        manager.createDummyData();
        UserInterface ui = new UserInterface();

        System.out.println(manager.getDoctorMap().get("001").getID());
        System.out.println(manager.getDoctorMap().get("001").getName());
        System.out.println(manager.getDoctorMap().get("001").getContactNumber());
        System.out.println(manager.getDoctorMap().get("001").getSpecialization());
        ui.displayApplication(manager);
    }
}