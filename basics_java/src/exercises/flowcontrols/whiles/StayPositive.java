package exercises.flowcontrols.whiles;
/* Created by limxuanhui on 20/6/22 */

public class StayPositive {
    public static void main(String[] args) {
        int startNum = 10;
        System.out.println("Counting down...");
        while (startNum >= 0) {
            System.out.println(startNum--);
        }
        System.out.println("\nBlast off!");
    }
}
