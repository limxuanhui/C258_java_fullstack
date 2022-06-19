package exercises.flowcontrols.whiles;
/* Created by limxuanhui on 20/6/22 */

import java.util.Scanner;

public class DoOrDoNot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Should I do it? (y/n) ");
        boolean doIt;

        if (input.next().equals("y")) {
            doIt = true;
        } else {
            doIt = false;
        }

        boolean iDidIt = false;

//        do {
//            iDidIt = true;
//            break;
//        } while (doIt);

        while (doIt) {
            iDidIt = true;
            break;
        }

        if (doIt && iDidIt) {
            System.out.println("I did it!");
        } else if (!doIt && iDidIt) {
            System.out.println("I know you said not to ... but I totally did anyways.");
        } else {
            System.out.println("Don't look at me, I didn't do anything!");
        }

        /*
            What does it print out if you tell it to do it?
            I did it!

            What if you tell it not to?
            I know you said not to ... but I totally did anyways.

            Comment out the do-while loop and write a while loop that checks the same condition and executes the same loop code.
            When you just have a while loop, what prints out when you tell it to do it?
            I did it!

            When you tell it not to?
            Don't look at me, I didn't do anything!
        */
    }
}
