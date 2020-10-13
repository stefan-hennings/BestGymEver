import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Database implements Serializable {
    private static List<Customer> customers = new ArrayList<>();
    
    public static List<Customer> getCustomers() {
        return customers;
    }
    
    public static void update() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("customerlist.ser"))) {
            out.writeObject(customers);
            System.out.println("Data saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    public static void initializeCustomers() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("customerlist.ser"))) {
            customers = (List<Customer>) in.readObject();
        } catch (Exception e) {
            readFromTextFile();
        }
    }
    
    public static void readFromTextFile() {
        try (Scanner scanner = new Scanner(new FileInputStream("customers.txt")).useDelimiter("[,\n]")) {
            while (scanner.hasNext()) {
                try {
                    customers.add(new Customer(scanner.nextLong(), scanner.next().trim(), LocalDate.parse(scanner.next().trim())));
                } catch (InputMismatchException e) {
                    break;
                }
                System.out.println(customers.get(customers.size()-1).getName());
                System.out.println(customers.get(customers.size()-1).getPersonalNumber());
                System.out.println(customers.get(customers.size()-1).getMembershipPaymentDate());
            }
//            Database.update();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
