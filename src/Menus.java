import java.util.Scanner;

public class Menus {
    static Scanner scanner = new Scanner(System.in);

    public static void mainMenu() {
        boolean running = true;
        while (running) {

            switch (IOTools.getInt(
                    "\n\nVad vill du göra?\n\n" +
                            "1. Checka in kund\n" +
                            "2. Kolla loggboken\n" +
                            "3. Avsluta programmet\n")) {
                case 1 -> Gym.checkIn();
                case 2 -> logMenu();
                case 3 -> running = !exitMenu();

                default -> System.out.println("Ange ett giltigt val! (1-3)");
            }
        }
    }

    private static void logMenu() {
        switch (IOTools.getInt("\n\nVilka besök vill du se?\n\n" +
                "1. Alla kunders\n" +
                "2. Ensklid kunds\n" +
                "3. Återgå till huvudmenyn\n")) {
            case 1 -> Gym.printAllVisitsAllCustomers();
            case 2 -> {
                Customer customer = Gym.findCustomer();
                if (customer != null) {
                    customer.printAllVisits();
                } else {
                    System.out.println("Kunden finns inte. ");
                }
            }
            case 3 -> {
                //return;
            }
            default -> System.out.println("Ange ett giltigt val! (1-3)");
        }
    }

    private static boolean exitMenu() {
        return IOTools.getString("Är du säker på att du vill avsluta? j/n\n").equalsIgnoreCase("j");
    }
}
