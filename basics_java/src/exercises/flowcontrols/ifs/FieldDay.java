package exercises.flowcontrols.ifs;
/* Created by limxuanhui on 20/6/22 */

import java.util.Scanner;

public class FieldDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your last name?");
        String lastName = scanner.nextLine();

        if (lastName.compareToIgnoreCase("Baggins") < 0) {
            System.out.println("Aha! You're on the team \"Black Holes\"!");
        } else if (lastName.compareToIgnoreCase("Dresden") < 0) {
            System.out.println("Aha! You're on the team \"Dark Wizards\"!");
        } else if (lastName.compareToIgnoreCase("Howl") < 0) {
            System.out.println("Aha! You're on the team \"Moving Castles\"!");
        } else if (lastName.compareToIgnoreCase("Potter") < 0) {
            System.out.println("Aha! You're on the team \"Golden Snitches\"!");
        } else if (lastName.compareToIgnoreCase("Vimes") < 0) {
            System.out.println("Aha! You're on the team \"Night Guards\"!");
        } else {
            System.out.println("Aha! You're on the team \"Black Holes\"!");
        }
    }
}
