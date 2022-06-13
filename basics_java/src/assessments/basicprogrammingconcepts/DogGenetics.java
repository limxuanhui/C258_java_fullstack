package assessments.basicprogrammingconcepts;
/* Created by limxuanhui on 10/6/22 */

import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
    /*
      Write a program that asks the user for the name of their dog,
      and then generates a fake DNA background report on the pet dog.
      It should assign a random percentage to 5 dog breeds
      (that should add up to 100%!)
    */

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    private static void generateReport(String name) {
        int total = 100;
        int num1 = random.nextInt(total) + 1;
        int num2 = random.nextInt(total) + 1;
        int num3 = random.nextInt(total) + 1;
        int num4 = random.nextInt(total) + 1;
        int num5 = random.nextInt(total) + 1;
        int sum = num1 + num2 + num3 + num4 + num5;
        float f1 = ((float)num1 / sum) * 100;
        float f2 = ((float)num2 / sum) * 100;
        float f3 = ((float)num3 / sum) * 100;
        float f4 = ((float)num4 / sum) * 100;
        float f5 = ((float)num5 / sum) * 100;

        System.out.println(name + " is:");
        System.out.println();
        System.out.println(f1 + "% St. Bernard");
        System.out.println(f2 + "% Chihuahua");
        System.out.println(f3 + "% Dramatic RedNosed Asian Pug");
        System.out.println(f4 + "% Common Cur");
        System.out.println(f5 + "% King Doberman");

        System.out.println();
        System.out.println("Wow, that's QUITE the dog!");
    }

    public static void main(String[] args) {
        System.out.println("What is your dog's name?");
        String dogName = scanner.nextLine();
        System.out.println("Well then, I have this highly reliable report on " + dogName + "'s prestigious background right here.");

        generateReport(dogName);
    }
}
