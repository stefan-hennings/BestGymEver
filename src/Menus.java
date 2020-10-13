import java.util.Scanner;

public class Menus {
    static Scanner scanner = new Scanner(System.in);
    
    public static void mainMenu() {
        Customer customer = null;
        switch (Utility.getInt("\nVad vill du göra?\n\n" +
                "1. Checka in via personnummer\n" +
                "2. Checka in via namn")) {
            case 1 -> customer = CheckIn.findCustomerByPersonalNumber(Utility.getLong("Ange personnummer: "));
            case 2 -> customer = CheckIn.findCustomerByName(Utility.getString("Ange namn: "));
            default -> System.out.println("Ange ett giltigt val! (1-2)");
        }
        verifyMembership(customer);
    }
    
    private static void verifyMembership(Customer customer) {
        if (customer == null) {
            System.out.println("Kunden är inte medlem. ");
        } else if (customer.isActiveMember()) {
            customer.logVisit();
            System.out.println("Kunden har aktivt medlemskap. ");
        } else {
            System.out.println("Kundens medlemskap har gått ut. ");
        }
    }
    
}
