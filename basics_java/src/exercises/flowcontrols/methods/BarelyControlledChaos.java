package exercises.flowcontrols.methods;
/* Created by limxuanhui on 20/6/22 */

import java.util.Random;
import java.util.Scanner;

public class BarelyControlledChaos {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {

        String color = getColor(); // call color method here
        String animal = getAnimal(); // call animal method again here
        String colorAgain = getColor(); // call color method again here
        int weight = getNumber(50, 100); // call number method,
        // with a range between 5 - 200
        int distance = getNumber(5, 200); // call number method,
        // with a range between 10 - 20
        int number = getNumber(10, 20); // call number method,
        // with a range between 10000 - 20000
        int time = getNumber(10000, 20000); // call number method,
        // with a range between 2 - 6

        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
                + weight + "lb " + " miniature " + animal
                + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over "
                + number + " " + colorAgain + " poppies for nearly "
                + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, "
                + "let me tell you!");
    }

    // ??? Method 1 ???
    public static String getColor() {
        int choice = random.nextInt(5) + 1;
        switch (choice) {
            case 1:
                return "red";
            case 2:
                return "blue";
            case 3:
                return "green";
            case 4:
                return "yellow";
            case 5:
                return "brown";
            default:
                return "black";
        }
    }

    // ??? Method 2 ???
    public static String getAnimal() {
        int choice = random.nextInt(5) + 1;
        switch (choice) {
            case 1:
                return "wild boar";
            case 2:
                return "kangaroo";
            case 3:
                return "crow";
            case 4:
                return "elephant";
            case 5:
                return "snake";
            default:
                return "lion";
        }
    }

    // ??? Method 3 ???
    public static int getNumber(int min, int max) {
        int choice = random.nextInt(max-min+1) + min;
        return choice;
    }
}
