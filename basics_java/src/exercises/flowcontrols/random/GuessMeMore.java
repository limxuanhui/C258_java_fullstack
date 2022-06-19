package exercises.flowcontrols.random;
/* Created by limxuanhui on 20/6/22 */

import java.util.Random;
import java.util.Scanner;

public class GuessMeMore {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int choice = random.nextInt(201) - 100;

        System.out.println("I've chosen a number between -100 and 100. Bet you can't guess it!");
        int guess = scanner.nextInt();
        System.out.println("Your guess: " + guess);
        if (guess == choice) {
            System.out.println("Wow, you guessed correctly!");
        } else {
            if (guess < choice){
                System.out.println("Ha, nice try - too low! Try again!");
            } else {
                System.out.println("Ha, nice try - too high! Try again!");
            }
            guess = scanner.nextInt();
            System.out.println("Your guess: " + guess);
            if (guess != choice) {
                System.out.println("Wow, nice guess! That was it!");
            } else {
                System.out.println("Wow, you guessed correctly!");
            }
        }
        System.out.println("The correct answer is " + choice);
    }
}
