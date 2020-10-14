import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {

    @Test
    public void initializeCustomersTest() {
        Database.activateTestMode("Bear Belle");
        File file = new File("test.ser");
        file.delete();

        Database.initializeCustomers();

        Customer customer = Gym.findCustomer();
        assertEquals(customer.getPersonalNumber(), 8104021234L);
        assertNotEquals(customer.getPersonalNumber(), 6536136);
        assertEquals(customer.getMembershipPaymentDate(), LocalDate.parse("2018-12-02"));
        assertNotEquals(customer.getMembershipPaymentDate(), LocalDate.parse("2018-12-20"));


        Database.initializeCustomers();

        Database.activateTestMode("9110261234");
        customer = Gym.findCustomer();
        assertEquals(customer.getName(), "Liu Lingren");
        assertNotEquals(customer.getName(), "Pelle");
        assertEquals(customer.getMembershipPaymentDate(), LocalDate.parse("2018-02-15"));
        assertNotEquals(customer.getMembershipPaymentDate(), LocalDate.parse("2018-12-02"));
    }


}
