package exercises.refactorintoobjects;
/* Created by limxuanhui on 14/6/22 */

import java.util.Random;
import java.util.Scanner;

class LuckySevens {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void gamble(float capital) {
        int rollCount = 0;
        float maxHolding = capital;
        int rollCountWithMaxHolding = 0;
        while (capital > 0) {
            rollCount++;
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;
            if (dice1 + dice2 == 7) {
                capital += 4;
                if (capital > maxHolding) {
                    maxHolding = capital;
                    rollCountWithMaxHolding = rollCount;
                }
            } else {
                capital -= 1;
            }
        }
        System.out.println("You are broke after " + rollCount + " rolls.");
        System.out.println("You should have quit after " + rollCountWithMaxHolding + " rolls when you had $" + maxHolding);
    }

    public void startLuckySevens() {
        System.out.println("How many dollars do you have?");
        float capital = scanner.nextFloat();
        gamble(capital);
    }
}

public class LuckySevensRefactor {
    public static void main(String[] args) {
        LuckySevens luckySevens = new LuckySevens();
        luckySevens.startLuckySevens();
    }
}
