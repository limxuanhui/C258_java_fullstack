package L9.BankingBackendApp;
/* Created by limxuanhui on 17/6/22 */

import java.util.Scanner;

public class Utility {
    private static final Scanner scanner = new Scanner(System.in);

    public static int promptInt() {
        boolean isValidInt = false;
        do {
            try {
                String sInt = scanner.nextLine();
                int num = Integer.parseInt(sInt);
                return num;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number, please try again");
            }
        } while (!isValidInt);
        return -1;
    }

    public static String promptString(String field) {
        System.out.println("Enter your " + field);
        String enteredField = scanner.nextLine();
        return enteredField;
    }
}
