package L8;
/* Created by limxuanhui on 15/6/22 */

public class TestException3 {
    /*
      finally keyword
    */
    public static void division(int a, int b) {
        int result = 0;
        result = a / b;
        System.out.println(result);
    }

    public static void main(String[] args) {
        System.out.println("Before exception");

        try {
            division(10, 0);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            // finally is used for resource de-allocation
            System.out.println("Finally always gets executed");
        }

        System.out.println("After exception");
    }
}
