package exercises.flowcontrols.whiles;
/* Created by limxuanhui on 20/6/22 */

import java.util.Random;

public class LazyTeenager {
    public static void main(String[] args) {
        Random random = new Random();

        int nagCount = 0;
        int cleanChance = 0;
        do {
            nagCount++;
            System.out.print("Clean your room!! ");
            int cleanOrNot = random.nextInt(100) + 1;

            if (nagCount < 8) {
                System.out.println("(x" + nagCount + ")");
                if (cleanOrNot <= cleanChance) {
                    System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
                    break;
                }
                cleanChance += 10;
            } else {
                System.out.println("That's IT, I'm doing it!!! YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
                break;
            }
        } while (true);
    }
}
