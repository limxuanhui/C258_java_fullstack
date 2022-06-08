package L3;
/* Created by limxuanhui on 8/6/22 */

import java.util.Scanner;

public class L3ScannerPractice {

    /*
        Ask the user for their name.
        Display that name and tell them yours (or your AI's name!).
        Ask them for their favorite color.
        Display the color they enter in a conversational way.
        Do the same thing with favorite food and number, and then say goodbye!
        Make sure you use the right variable with the right user input!
    */

    public static Scanner scanner = new Scanner(System.in);

    public static void questForTheUserInput() {
        String yourName;
        String yourQuest;
        double velocityOfSwallow;

        // We can use the Scanner's readLine to assign value to our strings
        // because its return type is string
        System.out.println("What is your name?? ");
        yourName = scanner.nextLine();

        System.out.println("What is your quest?! ");
        yourQuest = scanner.nextLine();

        // When we get to our double data type, we can use Scanner's nextDouble method
        // or we can use the Double.parseDouble to convert the nextLine's String

        System.out.println("What is the airspeed velocity of an unladen swallow?!?! ");
        velocityOfSwallow = Double.parseDouble(scanner.nextLine());
        System.out.println();
        System.out.println("How do you know " + velocityOfSwallow + " is correct, " + yourName + "?");
        System.out.println("You didn't even know if the swallow was African or European!");
        System.out.println("Maybe skip answering things about birds and instead go " + yourQuest + ".");
    }

    public static void passingTheTuringTest() {
        String favColour = "blue";

        System.out.println("Hello! I'm Jake. What's your name?");
        String name = scanner.nextLine();

        System.out.println("Hi " + name);
        System.out.println("What's your favourite colour?");
        String colour = scanner.nextLine();

        if (colour.toLowerCase() != favColour) {
            System.out.println(colour + "??? Ewwww. I prefer " + favColour);
        } else {
            System.out.println("OMG me too!");
        }

        System.out.println("What's your favourite food?");
        String food = scanner.nextLine();

        System.out.println("I like that too!");
        System.out.println("What's your favourite number then??");

        int number = scanner.nextInt();
        System.out.println("That must be your lucky number:)");

        System.out.println("Bye!");
    }





    public static void main(String[] args) {
//        questForTheUserInput();
//        passingTheTuringTest();
        int x = Integer.MAX_VALUE;
        int y = x + 1;
        System.out.println(x);
        System.out.println(y);


    }
}
