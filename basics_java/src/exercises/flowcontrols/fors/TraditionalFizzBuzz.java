package exercises.flowcontrols.fors;
/* Created by limxuanhui on 20/6/22 */

import java.util.Scanner;

public class TraditionalFizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many units of fizzing and buzzing do you need in your life?");
        int num = scanner.nextInt();
        int count = 0;
        for (int i = 0; ; i++) {
            if (i > 0) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("fizz buzz");
                    count++;
                } else if (i % 3 == 0) {
                    System.out.println("fizz");
                    count++;
                } else if (i % 5 == 0) {
                    System.out.println("buzz");
                    count++;
                } else {
                    System.out.println(i);
                }
            } else {
                System.out.println(i);
            }
            if (count == num) {
                break;
            }
        }
        System.out.println("TRADITION!!!!!");
    }
}
