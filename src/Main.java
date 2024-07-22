public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager();
        manager.createDummyData();
        UserInterface ui = new UserInterface();

        ui.displayApplication(manager);
    }
}