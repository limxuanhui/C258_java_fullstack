package exercises.flowcontrols.whiles;
/* Created by limxuanhui on 20/6/22 */

import java.util.Random;
import java.util.Scanner;

public class GuessMeFinally {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int choice = random.nextInt(201) - 100;
        System.out.println("I've chosen a number between -100 and 100. Betcha can't guess it!");
        boolean firstTry = true;
        while (true) {
            int guess = scanner.nextInt();
            System.out.println("Your guess: " + guess);
            if (guess == choice) {
                if (firstTry) {
                    System.out.println("Wow, nice guess! That was it!");
                } else {
                    System.out.println("Finally! It's about time you got it!");
                }
                break;
            } else if (guess < choice) {
                System.out.println("Ha, nice try - too low! Try again!");

            } else {
                System.out.println("Ha, nice try - too high! Try again!");
            }
            firstTry = false;
        }
    }
}
