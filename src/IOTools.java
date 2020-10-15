import java.util.Scanner;

public class IOTools {
    public static String getString(String question) {
        Scanner scanner = new Scanner(System.in);
        String response = null;
        while (response == null || response.isEmpty()) {
            System.out.print(question);
            response = scanner.nextLine();
        }
        return response;
    }
    
    public static double getDouble(String question) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(question);
                return Double.parseDouble(scanner.nextLine().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Ogiltigt värde! ");
            }
        }
    }
    
    public static int getInt(String question) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(question);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ogiltigt värde! Endast heltal är tillåtna. ");
            }
        }
    }
    
    public static long getLong(String question) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(question);
                return Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ogiltigt värde! Endast heltal är tillåtna. ");
            }
        }
    }
}
