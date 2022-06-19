package exercises.flowcontrols.whiles;
/* Created by limxuanhui on 20/6/22 */

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class BewareTheKraken {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Already, get those flippers and wetsuit on - we're going diving!");
        System.out.println("Here we goooOOooOooo.....! *SPLASH*");

        int depthDivedInFt = 0;

        // Turns out the ocean is only so deep, 36200 at the deepest survey,
        // so if we reach the bottom ... we should probably stop.
        while(depthDivedInFt < 36200){
            System.out.println("So far, we've swum " + depthDivedInFt + " feet");

            if(depthDivedInFt >= 20000){
                System.out.println("Uhhh, I think I see a Kraken, guys ....");
                System.out.println("TIME TO GO!");
                break;
            }

            // I can swim, really fast! 500ft at a time!
            depthDivedInFt += 1000;
            int randomFish = random.nextInt(3) + 1;
            System.out.println("I see a " + (randomFish == 1 ? "shark..." : (randomFish == 2) ? "catfish..." : "swordfish"));

            System.out.println("Want to stop?");
            String stopNow = scanner.next();
            if (stopNow.toLowerCase(Locale.ROOT).equals("y")) break;
        }
        System.out.println("");
        System.out.println("We ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I bet we can do better next time!");

        /*
            Add in another break command: ask the user if they want to stop. If they do, surface.
            Also, every time we go deeper, add in a printout for a random fish type. (at least 3 types.)

            What changes if you turn the while loop's condition to just read "true". Answer in a comment.
            Infinite loop unless user stops.
        */
    }
}