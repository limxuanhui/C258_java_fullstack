package L8;
/* Created by limxuanhui on 15/6/22 */

import java.util.Scanner;

public class TestException1 {

    public static void division(int a, int b) {
        /*
          With 'throws ArithmeticException', we do not need to have try catch here.
          The exception will be thrown to caller of this function.
        */
        int result = 0;
//        try {
//            if (b == 0) throw new ArithmeticException("I Cannot divide by zero");
        result = a / b;
//        } catch (ArithmeticException ex) {
//            System.out.println("ex.getMessage: " + ex.getMessage());
//            System.out.println("ex.getCause: " + ex.getCause());
//            System.out.println("ex.getLocalizedMessage: " + ex.getLocalizedMessage());
//            throw ex;
//        }
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Before exception");
        try {
            division(10, 0);
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("After exception");
        System.out.println("Enter a number");
        int x = scanner.nextInt();
        System.out.println(x);

    }
}
