import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void isActiveMemberTest() {
        Database.activateTestMode();
        Database.getCustomers().add(new Customer(1, "Daniel", LocalDate.now()));
        Database.getCustomers().add(new Customer(2, "Elias", LocalDate.now().minusYears(1)));

        assertTrue(Database.getCustomers().get(Database.getCustomers().size() - 2).isActiveMember());
        assertFalse(Database.getCustomers().get(Database.getCustomers().size() - 1).isActiveMember());
    }

    @Test
    public void logVisitTest() {
        Database.activateTestMode();
        Customer customer = new Customer(3, "Erik", LocalDate.now());
        Database.getCustomers().add(customer);
        assertTrue(customer.getVisits().isEmpty());
        customer.logVisit();
        assertFalse(customer.getVisits().isEmpty());
        assertEquals(customer.getVisits().get(0), LocalDate.now());
    }
}
