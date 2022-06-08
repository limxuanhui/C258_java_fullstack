package L1;
/* Created by limxuanhui on 6/6/22 */

import java.util.Scanner;

public class L1Math {
    public static Scanner scanner = new Scanner(System.in);

    public static int add(int x, int y) {
        return x + y;
    }

    public static int subtract(int x, int y) {
        return x - y;
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public static double divide(int x, int y) {
        if (y == 0) {
            return Double.MAX_VALUE;
        }
        return (double)x / y;
    }

    public static void computeAll(int x, int y) {
        System.out.println(add(x, y));
        System.out.println(subtract(x, y));
        System.out.println(multiply(x, y));
        System.out.println(divide(x, y));
    }

    public static void printAdd(int x, int y) {
        System.out.println(x + " / " + y + " = " + (x + y));
    }

    public static void printSubtract(int x, int y) {
        System.out.println(x + " - " + y + " = " + (x - y));
    }

    public static void printMultiply(int x, int y) {
        System.out.println(x + " * " + y + " = " + x * y);
    }

    public static void printDivide(int x, int y) {
        if (y == 0) {
            System.out.println("Cannot divide by 0");
            return;
        }
        System.out.println(x + " / " + y + " = " + (double)x / y);
    }

    public static void printComputeAll(int x, int y) {
        printAdd(x, y);
        printSubtract(x, y);
        printMultiply(x, y);
        printDivide(x, y);
    }

    public static void printOptions(int x, int y) {
        System.out.println("==============");
        System.out.println("1. " + x + " + " + y);
        System.out.println("2. " + x + " - " + y);
        System.out.println("3. " + x + " * " + y);
        System.out.println("4. " + x + " / " + y);
        System.out.println("9. Quit");
        System.out.println("==============");
    }

    public static void calculate(int x, int y, int opt) {
        switch (opt) {
            case 1:
                printAdd(x, y);
                break;
            case 2:
                printSubtract(x, y);
                break;
            case 3:
                printMultiply(x, y);
                break;
            case 4:
                printDivide(x, y);
                break;
            default:
                System.out.println("Choose from 1 - 4");
        }
    }

    public static void calculateAll(int x, int y) {
        printComputeAll(x, y);
    }

    public static int[] takeUserInputs() {
        int[] inputs = new int[2];
        System.out.println("Please enter x:");
        inputs[0] = scanner.nextInt();
        System.out.println("Please enter y:");
        inputs[1] = scanner.nextInt();
        return inputs;
    }

    public static void doMath() {
        System.out.println("Doing single math operation");
        int[] inputs = takeUserInputs();
        while (true) {
            printOptions(inputs[0], inputs[1]);
            int opt = scanner.nextInt();
            if (opt == 9) {
                System.out.println("Bye");
                break;
            }
            calculate(inputs[0], inputs[1], opt);
        }
    }

    public static void doAllMath() {
        System.out.println("Doing all math together");
        int[] inputs = takeUserInputs();
        calculateAll(inputs[0], inputs[1]);
    }

    public static void main(String[] args) {
        doMath();
        doAllMath();
    }
}
