public class Main {
    public static void main(String[] args) {
        Database.initializeCustomers();
        while (true) {
            Menus.mainMenu();
        }
    }
}
