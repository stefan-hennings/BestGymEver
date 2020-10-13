public class Utility {
    public static String getString(String question) {
        String response = null;
        while (response == null || response.isEmpty()) {
            System.out.print(question);
            response = Menus.scanner.nextLine();
        }
        return response;
    }
    
    public static double getDouble(String question) {
        while (true) {
            try {
                System.out.print(question);
                return Double.parseDouble(Menus.scanner.nextLine().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Ogiltigt värde! ");
            }
        }
    }
    
    public static int getInt(String question) {
        while (true) {
            try {
                System.out.print(question);
                return Integer.parseInt(Menus.scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ogiltigt värde! ");
            }
        }
    }
    
    public static long getLong(String question) {
        while (true) {
            try {
                System.out.print(question);
                return Long.parseLong(Menus.scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ogiltigt värde! ");
            }
        }
    }
}
