package L2;
/* Created by limxuanhui on 7/6/22 */

import java.util.Scanner;

public class L2IfElseClubBouncer {
    /*
        1) WAP to examine if a person is allowed in a party or not based on the rules below:
        i) should be older than 21, ii) should not be single, iii) should wear shoes.
        (USE nested if-else)
    */
    public static Scanner scanner = new Scanner(System.in);

    public static int checkAge() {
        System.out.println("What is your age?");
        int age = scanner.nextInt();
        return age;
    }

    public static int checkSingleStatus() {
        System.out.println("Are you single?");
        System.out.println("\t 1. Yes");
        System.out.println("\t 2. No");
        int isSingle = scanner.nextInt();
        return isSingle;
    }

    public static int checkIfWearingShoes() {
        System.out.println("Are you wearing shoes?");
        System.out.println("\t 1. Yes");
        System.out.println("\t 2. No");
        int isWearingShoes = scanner.nextInt();
        return isWearingShoes;
    }

    public static void startBouncing() {
        int age = checkAge();
        if (age >= 21) {
            int isSingle = checkSingleStatus();
            if (isSingle == 2) {
                int isWearingShoes = checkIfWearingShoes();
                if (isWearingShoes == 1) {
                    System.out.println("Welcome to the club!");
                } else {
                    System.out.println("Sorry, please wear shoes to enter.");
                }
            } else {
                System.out.println("Sorry, singles are not allowed to enter.");
            }
        } else {
            System.out.println("Sorry, underage are not allowed to enter.");
        }
    }

    public static void main(String[] args) {
        startBouncing();
    }
}
