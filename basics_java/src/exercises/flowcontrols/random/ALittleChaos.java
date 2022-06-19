package exercises.flowcontrols.random;
/* Created by limxuanhui on 20/6/22 */

import java.util.Random;

public class ALittleChaos {
    public static void main(String[] args) {
        Random randomizer = new Random();

        System.out.println("Random can make integers: " + randomizer.nextInt());
        System.out.println("Or a double: " + randomizer.nextDouble());
        System.out.println("Or even a boolean: " + randomizer.nextBoolean());

        int num = randomizer.nextInt(100);

        System.out.println("You can store a randomized result: " + num);
        System.out.println("And use it over and over again: " + num + ", " + num);

        System.out.println("Or just keep generating new values");
        System.out.println("Here's a bunch of numbers from 0-100: ");

        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.println(randomizer.nextInt(101));

        System.out.println(randomizer.nextInt(100));
        System.out.println(randomizer.nextFloat());
        System.out.println(randomizer.nextDouble());
        /*
            What happens if you change randomizer.Next(101) to randomizer.Next(51) + 50? (Answer in a comment.)
            Always get a number at least 50.

            Can you include random numbers in a math statement? (Answer in a comment.)
            Yes.

            Experiment with different number types to see what the outcomes look like. (Record results in comments.)
            53 (nextInt)
            0.5015591 (nextFloat)
            0.5128883907870833 (nextDouble)
        */
    }
}
