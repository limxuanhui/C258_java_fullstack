package L5;
/* Created by limxuanhui on 9/6/22 */

import java.util.Locale;
import java.util.Scanner;

class Calculator {
    /*
      2) Create a command line application of calculator using OOP.
    */
    protected boolean switchedOn;
    protected static Scanner scanner = new Scanner(System.in);

    public Calculator() {
        System.out.println("Calculator constructor called");
        this.switchedOn = false;
    }

    public void switchOn() {
        this.switchedOn = true;
        System.out.println("===== Calculator =====");
        this.run();
    }
    public void switchOff() {
        this.switchedOn = false;
        System.out.println("Bye! Shutting down...");
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

            calculate(x, y, operator);
            carryOnOrNot();
        }
    }
    protected void calculate(double x, double y, int operator) {
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
    }
    protected void carryOnOrNot() {
        System.out.println("Do you want to carry on?");
        boolean carryOn = promptYesNo();
        if (!carryOn) {
            switchOff();
        }
    }
    protected void displayCalculatorOperators() {
        System.out.println("1. +");
        System.out.println("2. -");
        System.out.println("3. *");
        System.out.println("4. /");
    }
    protected int promptOperator() {
        boolean isValid = false;
        do {
            try {
                displayCalculatorOperators();
                String so = scanner.nextLine();
                int operator = Integer.parseInt(so);
                return operator;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid operator, please try again.");
            }

        } while (!isValid);
        return -1;
    }
    protected static double promptOperand() {
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
    protected static boolean promptYesNo() {
        System.out.println("Y or N?");
        String yesOrNo = scanner.nextLine();
        boolean isYes = yesOrNo.toLowerCase(Locale.ROOT).charAt(0) != 'n';
        return isYes;
    }

    protected static double add(double x, double y) {
        return x + y;
    }
    protected static double subtract(double x, double y) {
        return x - y;
    }
    protected static double multiply(double x, double y) {
        return x * y;
    }
    protected static double divide(double x, double y) {
        if (y == 0) {
            System.out.println("Cannot divide by 0");
            return Double.MAX_VALUE;
        }
        return x / y;
    }
}

class ScientificCalculator extends Calculator {
    public ScientificCalculator() {
        super();
        System.out.println("Scientific calculator constructor called");
    }

    @Override
    public void switchOn() {
        this.switchedOn = true;
        System.out.println("===== Scientific Calculator =====");
        this.run();
    }
    private void run() {
        while (this.switchedOn) {
            double x = promptOperand();
            int operator = promptOperator();
            while (operator < 1 || operator > 12) {
                System.out.println("Invalid operator, please try again.");
                operator = promptOperator();
            }

            if (operator >= 1 && operator <= 4) {
                double y = promptOperand();
                calculate(x, y, operator);
            } else {
                calculate(x, operator);
            }

            carryOnOrNot();
        }
    }
    private void calculate(double x, int operator) {
        switch (operator) {
            case 5:
                double res = sqrt(x);
                System.out.println("\t" + "√" + x + " = " + res);
                break;
            case 6:
                res = cbrt(x);
                System.out.println("\t" + "∛" + x + " = " + res);
                break;
            case 7:
                res = square(x);
                System.out.println("\t" + x + "^2" + " = " + res);
                break;
            case 8:
                res = cube(x);
                System.out.println("\t" + x + "^3" + " = " + res);
                break;
            case 9:
                res = sin(x);
                System.out.println("\t" + "sin(" + x + ")" + " = " + res);
                break;
            case 10:
                res = cos(x);
                System.out.println("\t" + "cos(" + x + ")" + " = " + res);
                break;
            case 11:
                res = tan(x);
                System.out.println("\t" + "tan(" + x + ")" + " = " + res);
                break;
        }
    }
    protected void displayCalculatorOperators() {
        super.displayCalculatorOperators();
        System.out.println("5. √");
        System.out.println("6. ∛");
        System.out.println("7. square");
        System.out.println("8. cube");
        System.out.println("9. sin");
        System.out.println("10. cos");
        System.out.println("11. tan");
    }
    protected int promptOperator() {
        boolean isValid = false;
        do {
            try {
                displayCalculatorOperators();
                String so = scanner.nextLine();
                int operator = Integer.parseInt(so);
                return operator;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid operator, please try again.");
            }

        } while (!isValid);
        return -1;
    }

    private static double sqrt(double x) {
        if (x < 0) {
            System.out.println("Cannot square root negative numbers!");
        }
        return Math.sqrt(x);
    }
    private static double cbrt(double x) {
        return Math.cbrt(x);
    }
    private static double square(double x) {
        return x * x;
    }
    private static double cube(double x) {
        return x * x * x;
    }
    private static double sin(double x) {
        return Math.sin(x);
    }
    private static double cos(double x) {
        return Math.cos(x);
    }
    private static double tan(double x) {
        return Math.tan(x);
    }
}

public class L5Q1 {

    public static void main(String[] args) {
        ScientificCalculator sc = new ScientificCalculator();
        sc.switchOn();
    }
}
