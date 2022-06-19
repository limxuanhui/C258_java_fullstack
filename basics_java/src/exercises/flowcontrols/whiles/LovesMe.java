package exercises.flowcontrols.whiles;
/* Created by limxuanhui on 20/6/22 */

public class LovesMe {
    public static void main(String[] args) {
        System.out.println("Well here goes nothing...");
        int petalsLeft = 34;
        while (petalsLeft >= 0) {
            if (petalsLeft % 2 == 0) {
                System.out.println("It LOVES me");
                if (petalsLeft == 0) {
                    System.out.println("I knew it! It LOVES ME!");
                }
            } else {
                System.out.println("It loves me NOT");
            }
            petalsLeft--;
        }

        /*
          Used while loop. No need for the do block.
        */
    }
}
