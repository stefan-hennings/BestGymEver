import java.time.LocalDate;

public class CheckIn {

    public static Customer findCustomer(String name) {
        for (Customer customer : Database.getCustomers()) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    public static Customer findCustomer(Long personalNumber) {
        for (Customer customer : Database.getCustomers()) {
            if (customer.getPersonalNumber() == personalNumber) {
                return customer;
            }
        }
        return null;
    }

    public static void checkIn(Customer customer) {
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
