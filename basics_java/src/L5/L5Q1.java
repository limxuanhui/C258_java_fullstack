package L4;
/* Created by limxuanhui on 9/6/22 */

import java.util.Locale;
import java.util.Scanner;

class Calculator {
    /*
      2) Create a command line application of calculator using OOP.
    */

    private boolean switchedOn;
    private static Scanner scanner = new Scanner(System.in);

    Calculator() {
        this.switchedOn = false;
    }

    public void switchOn() {
        this.switchedOn = true;
        System.out.println("===== Calculator =====");
        this.run();
    }

    private void run() {
        while (this.switchedOn) {
            double x = promptOperand();
            int operator = promptOperator();
            while (operator < 1 || operator > 4) {
                System.out.println("Invalid operator, please try again.");
                operator = promptOperator();
            }
            double y = promptOperand();

            switch (operator) {
                case 1:
                    double res = add(x, y);
                    System.out.println("\t" + x + " + " + y + " = " + res);
                    break;
                case 2:
                    res = subtract(x, y);
                    System.out.println("\t" + x + " - " + y + " = " + res);
                    break;
                case 3:
                    res = multiply(x, y);
                    System.out.println("\t" + x + " * " + y + " = " + res);
                    break;
                case 4:
                    res = divide(x, y);
                    if (res != Double.MAX_VALUE) {
                        System.out.println("\t" + x + " / " + y + " = " + res);
                    }
                    break;
            }

            String carryOn = promptYesNo();
            if (carryOn.toLowerCase(Locale.ROOT).charAt(0) == 'n') {
                this.switchOff();
            }
        }
    }

    public void switchOff() {
        this.switchedOn = false;
        System.out.println("Bye! Shutting down...");
    }

    public static double promptOperand() {
        boolean isValid = false;
        do {
            try {
                System.out.println("_: ");
                String sx = scanner.nextLine();
                double x = Double.parseDouble(sx);
                return x;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid operand, please try again.");
            }

        } while (!isValid);
        return -1;
    }

    private static int promptOperator() {
        boolean isValid = false;
        do {
            try {
                System.out.println("1. +");
                System.out.println("2. -");
                System.out.println("3. *");
                System.out.println("4. /");
                String so = scanner.nextLine();
                int operator = Integer.parseInt(so);
                return operator;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid operator, please try again.");
            }

        } while (!isValid);
        return -1;
    }

    private static String promptYesNo() {
        boolean isValid = false;
        do {
            System.out.println("Do you want to carry on?");
            try {
                System.out.println("Y or N?");
                String yesOrNo = scanner.nextLine();
                return yesOrNo;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid response, please try again.");
            }

        } while (!isValid);
        return null;
    }

    private static double add(double x, double y) {
        return x + y;
    }

    private static double subtract(double x, double y) {
        return x - y;
    }

    private static double multiply(double x, double y) {
        return x * y;
    }

    private static double divide(double x, double y) {
        if (y == 0) {
            System.out.println("Cannot divide by 0");
            return Double.MAX_VALUE;
        }
        return x / y;
    }
}

public class L4Q2 {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.switchOn();
    }
}
