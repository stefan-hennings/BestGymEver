import java.time.LocalDate;

public class CheckIn {

    public static Customer findCustomerByName(String name) {
        for (Customer customer : Database.getCustomers()) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    public static Customer findCustomerByPersonalNumber(Long personalNumber) {
        for (Customer customer : Database.getCustomers()) {
            if (customer.getPersonalNumber() == personalNumber) {
                return customer;
            }
        }
        return null;
    }
}
