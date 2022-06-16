package L8;
/* Created by limxuanhui on 15/6/22 */

// Exception --> scenario which are unusual and breaks our flow of program

public class TestException {

    public static void main(String[] args) {
        System.out.println("Before exception!");
        int x = 10;
        int y = 0;
        try {
            double result = (double)x/y;
            System.out.println("The value of result is " + result);
            System.out.println("After exception!");
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Cannot divide by zero!");
        }
    }
}
