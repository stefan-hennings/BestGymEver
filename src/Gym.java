public class Gym {

    public static void addCustomer(Customer customer) {

    }

    public static Customer findCustomer() {
        String input;
        if (Database.testing) {
            input = Database.testInput;
        } else {
            input = IOTools.getString("Skriv in namn eller personnummer: ").trim();
        }
        try {
            return Gym.findCustomer(Long.parseLong(input));
        } catch (NumberFormatException e) {
            return Gym.findCustomer(input);
        }
    }

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

    public static void checkIn() {
        Customer customer = findCustomer();
        if (customer == null) {
            System.out.println("Kunden är inte medlem. ");
        } else if (customer.isActiveMember()) {
            customer.logVisit();
            System.out.println("Kunden har aktivt medlemskap. ");
        } else {
            System.out.println("Kundens medlemskap har gått ut. ");
        }
    }

    public static void printAllVisitsAllCustomers() {
        for (Customer customer : Database.getCustomers()) {
            if (!customer.getVisits().isEmpty()) {
                customer.printAllVisits();
            }
        }
    }
}
