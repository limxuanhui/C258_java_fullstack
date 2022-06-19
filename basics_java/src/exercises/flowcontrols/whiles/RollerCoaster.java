package exercises.flowcontrols.whiles;
/* Created by limxuanhui on 20/6/22 */

import java.util.Scanner;

public class RollerCoaster {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("We're going to go on a roller coaster...");
        System.out.println("Let me know when you want to get off...!");

        String keepRiding = "y";
        int loopsLooped = 0;
//        while (keepRiding.equals("y")) {
        while (keepRiding.equals("n")) {
                System.out.println("WHEEEEEEEEEEEEEeEeEEEEeEeeee.....!!!");
                System.out.print("Want to keep going? (y/n) :");
                keepRiding = userInput.nextLine();
                loopsLooped++;
        }

        System.out.println("Wow, that was FUN!");
        System.out.println("We looped that loop " + loopsLooped + " times!!");

        /*
            What happens if the user enters a value that is neither "y" nor "n"?
            (Make a guess first, and then test to see if your guess was right.)
            Loop ends

            What happens if we change the condition to check for a no answer instead?
            (To do this, comment out the old condition, and write a new one!)
        */
    }
}