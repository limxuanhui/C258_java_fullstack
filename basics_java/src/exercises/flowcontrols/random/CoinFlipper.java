package exercises.flowcontrols.random;
/* Created by limxuanhui on 20/6/22 */

import java.util.Random;

public class CoinFlipper {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("Ready, Set, Flip....!!");
        boolean flipIsHead = random.nextBoolean();
        if (flipIsHead) {
            System.out.println("You got HEADS!");
        } else {
            System.out.println("You got TAILS!");
        }
    }
}
