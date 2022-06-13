package exercises.flowcontrols.ifs;
/* Created by limxuanhui on 10/6/22 */

import java.util.Scanner;

public class GuessMe {
    /*
      Create a new class file named GuessMe.
      Write a program that that has an integer of your choice stored in a variable.
      The program asks the user to pick a number.
      Regardless of the choice, the program should print out what the user entered as part of the response.
      If their choice is equal to the number print out: "Wow, nice guess! That was it!"
      If their choice is less to the number print out: "Ha, nice try - too low! I chose #."
      If their choice is greater to the number print out: "Too bad, way too high. I chose #."
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answer = 5;
        System.out.println("Pick a number from 1 to 10:");
        int input = scanner.nextInt();
        System.out.println("Your input: " + input);
        if (input == answer) {
            System.out.println("Wow, nice guess! That was it!");
        } else if (input < answer) {
            System.out.println("Ha, nice try - too low! I chose " + answer + ".");
        } else {
            System.out.println("Too bad, way too high. I chose " + answer + ".");
        }
    }
}
