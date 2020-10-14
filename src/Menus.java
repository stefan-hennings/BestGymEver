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
                case 1 -> checkInMenu();
                case 2 -> System.out.println();
                case 3 -> running = false;

                default -> System.out.println("Ange ett giltigt val! (1-3)");
            }

        }
    }

    private static void checkInMenu() {
        switch (IOTools.getInt("\n\nVad vill du göra?\n\n" +
                "1. Checka in via personnummer\n" +
                "2. Checka in via namn\n" +
                "3. Återgå till huvudmenyn\n")) {
            case 1 -> CheckIn.checkIn(CheckIn.findCustomer(IOTools.getLong("Ange personnummer: ")));
            case 2 -> CheckIn.checkIn(CheckIn.findCustomer(IOTools.getString("Ange namn: ")));
            case 3 -> {
                return;
            }
            default -> System.out.println("Ange ett giltigt val! (1-3)");
        }
    }
}
