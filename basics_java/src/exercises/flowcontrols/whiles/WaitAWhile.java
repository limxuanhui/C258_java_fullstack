package exercises.flowcontrols.whiles;
/* Created by limxuanhui on 20/6/22 */

public class WaitAWhile {
    public static void main(String[] args) {
        int timeNow = 5;
        int bedTime = 10;

        while (timeNow < bedTime) {
            System.out.println("It's only " + timeNow + " o'clock!");
            System.out.println("I think I'll stay up just a liiiiittle longer....");
            timeNow++; // Time passes
        }

        System.out.println("Oh. It's " + timeNow + " o'clock.");
        System.out.println("Guess I should go to bed ...");

        /*
            Setting bedTime to 11 increases the loop by one more time
            Setting timeNow to 11 will cause the while loop to not run
            Commenting out ++ leads to infinite loop
        */
    }
}
