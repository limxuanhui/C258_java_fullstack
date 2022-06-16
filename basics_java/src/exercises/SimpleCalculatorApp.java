package exercises;
/* Created by limxuanhui on 14/6/22 */

import java.util.Scanner;

class SimpleCalculator {
    public static int add(int a, int b) {
        return a + b;
    }
    public static int subtract(int a, int b) {
        return a - b;
    }
    public static int multiply(int a, int b) {
        return a * b;
    }
    public static double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero");
            return Double.MAX_VALUE;
        }
        return (double)a / b;
    }
    public void calculate(int operator, int a, int b) {
        switch (operator) {
            case 1:
                double res = add(a, b);
                System.out.println(a + " + " + b + " = " + res);
                break;
            case 2:
                res = subtract(a, b);
                System.out.println(a + " - " + b + " = " + res);
                break;
            case 3:
                res = multiply(a, b);
                System.out.println(a + " * " + b + " = " + res);
                break;
            case 4:
                res = divide(a, b);
                if (res != Double.MAX_VALUE) {
                    System.out.println(a + " / " + b + " = " + res);
                }
                break;
        }
    }
}

public class SimpleCalculatorApp {
    private static Scanner scanner = new Scanner(System.in);
    public static void displayChoices() {
        System.out.println("===== Simple Calculator App =====");
        System.out.println("1. +");
        System.out.println("2. -");
        System.out.println("3. *");
        System.out.println("4. /");
        System.out.println("5. Quit");
    }

    public static boolean isValidOperator(int operator) {
        if (operator < 1 || operator > 5) {
            System.out.println("Invalid operator!");
            return false;
        }
        return true;
    }

    public static int promptInteger() {
        boolean isValid = false;
        do {
            try {
                System.out.println("Enter an integer:");
                String stringChoice = scanner.nextLine();
                int operator = Integer.parseInt(stringChoice);
                return operator;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid choice, please try again");
            }
        } while(!isValid);
        return -1;
    }

    public static int promptOperator() {
        int choice;
        do {
            displayChoices();
            choice = promptInteger();
        } while (!isValidOperator(choice));
        return choice;
    }

    public static void main(String[] args) {
        SimpleCalculator simpleCalculator = new SimpleCalculator();

        do {
            int choice = promptOperator();
            if (choice == 5) {
                System.out.println("Thank you and bye!");
                break;
            }
            int a = promptInteger();
            int b = promptInteger();
            simpleCalculator.calculate(choice, a, b);
        } while (true);


    }
}


