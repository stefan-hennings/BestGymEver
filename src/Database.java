import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Database implements Serializable {
    public static boolean testing = false;
    public static String testInput;

    public static String textFile = "customers.txt";
    public static String database = "customerlist.ser";
    private static List<Customer> customers = new ArrayList<>();

    public static void activateTestMode(String input) {
        testInput = input;
        activateTestMode();
    }

    public static void activateTestMode() {
        testing = true;
        database = "test.ser";
        textFile = "test.txt";
        initializeCustomers();
    }

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(database))) {
            out.writeObject(customers);
            System.out.println("Data saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    public static void initializeCustomers() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(database))) {
            customers = (List<Customer>) in.readObject();
        } catch (Exception e) {
            readFromTextFile();
        }
    }
    
    public static void readFromTextFile() {
        try (Scanner scanner = new Scanner(new FileInputStream(textFile)).useDelimiter("[,\n]")) {
            while (scanner.hasNext()) {
                try {
                    customers.add(new Customer(scanner.nextLong(), scanner.next().trim(), LocalDate.parse(scanner.next().trim())));
                } catch (InputMismatchException e) {
                    break;
                }
                /*System.out.println(customers.get(customers.size()-1).getName());
                System.out.println(customers.get(customers.size()-1).getPersonalNumber());
                System.out.println(customers.get(customers.size()-1).getMembershipPaymentDate());*/
            }
            Database.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
