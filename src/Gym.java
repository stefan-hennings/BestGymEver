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
            System.out.println("Kunden har aktivt medlemskap. ");
            customer.logVisit();
            System.out.println("Besöket har loggats. ");
        } else {
            System.out.println("Kundens medlemskap gick ut " + customer.getMembershipPaymentDate().plusYears(1));
        }
    }

    public static void printAllVisitsAllCustomers() {
        boolean hasBeenVisited = false;
        for (Customer customer : Database.getCustomers()) {
            if (!customer.getVisits().isEmpty()) {
                customer.printAllVisits();
                hasBeenVisited = true;
                System.out.println();
            }
        }
        if (!hasBeenVisited) {
            System.out.println("Ingen har besökt gymmet. ");
        }
    }
}
