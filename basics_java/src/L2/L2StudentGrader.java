package L2;
/* Created by limxuanhui on 7/6/22 */

import java.util.Scanner;

public class L2StudentGrader {
    /*
        2) WAP for calculating students grade based on below rules:
        i) if he scored 90-100 % marks then his 'A', 80-90 --> 'B', 70-80 --> 'C' otherwise failed.
    */

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Please input your score:");
        boolean correct = scanner.nextBoolean();
        System.out.println(correct);

        int score = scanner.nextInt();
        if (score >= 90) {
            System.out.println("Grade is A");
        } else if (score >= 80) {
            System.out.println("Grade is B");
        } else if (score >= 70) {
            System.out.println("Grade is C");
        } else {
            System.out.println("Failed");
        }
    }
}
