import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Database implements Serializable {
    private static List<Customer> customers = new ArrayList<>();

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static void serialize() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("customerlist.ser"))){
            out.writeObject(customers);
            System.out.println("Data saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void deserialize() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("customerlist.ser"))){
            customers = (List<Customer>) in.readObject();
        } catch (Exception e) {
            readFromTextFile();
        }
    }

    public static void readFromTextFile() {
        while (true) {
            try (Scanner scanner = new Scanner(new FileInputStream("customers.txt"))) {
                customers.add(new Customer(scanner.nextLong(), scanner.nextLine(), LocalDate.parse(scanner.nextLine())));
                if (!scanner.hasNext()) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
