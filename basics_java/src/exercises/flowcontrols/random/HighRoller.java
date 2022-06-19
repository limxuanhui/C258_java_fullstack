package exercises.flowcontrols.random;
/* Created by limxuanhui on 20/6/22 */

import java.util.Random;
import java.util.Scanner;

public class HighRoller {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random diceRoller = new Random();
        System.out.println("How many sides does your die have?");
        int numSides = scanner.nextInt();

        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        int rollResult = diceRoller.nextInt(numSides) + 1;

        System.out.println("I rolled a " + rollResult);
        if (rollResult == 1) {
            System.out.println("You rolled a critical failure!");
        } else if (rollResult == numSides) {
            System.out.println("You rolled a critical! Nice job!");
        }
    }
}