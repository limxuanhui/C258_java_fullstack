package exercises.flowcontrols.whiles;
/* Created by limxuanhui on 20/6/22 */

import java.util.Scanner;

public class StayPositive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What number should I count down from?");
        int startNum = scanner.nextInt();
        System.out.println("\nHere goes!\n");

        while (startNum >= 0) {
            for (int i = 0; i < 10; i++) {
                System.out.print(startNum-- + " ");
                if (startNum < 0) break;
            }
            System.out.println();
        }
        System.out.println("\nBlast off!");
    }
}
