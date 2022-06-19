package exercises.flowcontrols.whiles;
/* Created by limxuanhui on 20/6/22 */

import java.util.Random;

public class MaybeItLovesMe {
    public static void main(String[] args) {
        Random random = new Random();
        int petalsLeft = random.nextInt(77) + 13;
        System.out.println("Well here goes nothing...");
        boolean lovesMe = true;
        while (petalsLeft > 0) {
            if (lovesMe) {
                System.out.println("It LOVES me!");
                if (petalsLeft == 1) {
                    System.out.println("Oh, wow! It really LOVES me!");
                }
                lovesMe = false;
            } else {
                System.out.println("It loves me NOT!");
                lovesMe = true;
                if (petalsLeft == 1) {
                    System.out.println("Awwww, bummer.");
                }
            }
            petalsLeft--;
        }
    }
}
