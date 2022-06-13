package assessments.basicprogrammingconcepts;
/* Created by limxuanhui on 10/6/22 */

import java.util.Scanner;

public class HealthyHearts {
    /*
      Make a simple calculator that asks the user for their age. Then calculate the healthy heart rate range for
      that age, and display it.
      - Their maximum heart rate should be 220 - their age.
      - The target heart rate zone is the 50 - 85% of the maximum.*/

    private static Scanner scanner = new Scanner(System.in);

    private static int promptInteger() {
        boolean isValid = false;
        do {
            try {
                String so = scanner.nextLine();
                int number = Integer.parseInt(so);
                return number;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number, please try again.");
            }
        } while (!isValid);
        return -1;
    }

    private static void generateHeartRateReport(int age) {
        int maxHeartRate = 220 - age;
        System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute");
        System.out.println("Your target HR Zone is " + (int)(0.5*maxHeartRate) + " - " + (int)(0.85*maxHeartRate) + " beats per minute");
    }

    public static void main(String[] args) {
        System.out.println("What is your age?");
        int age = promptInteger();
        while (age < 0) {
            age = promptInteger();
        }
        generateHeartRateReport(age);

    }
}
