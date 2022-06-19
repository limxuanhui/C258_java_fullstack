package exercises.flowcontrols.ifs;
/* Created by limxuanhui on 20/6/22 */

import java.util.Scanner;

public class MiniZork {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.println("On the right of the white house is a lake.");
        System.out.print("Go to the house, the lake, or open the mailbox? ");

        String action = userInput.nextLine();

        if (action.equals("open the mailbox")) {
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in? ");
            action = userInput.nextLine();

            if (action.equals("look inside")) {
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking? ");
                action = userInput.nextLine();

                if (action.equals("keep looking")) {
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you alive. Possibly a wise choice.");
                }
            } else if (action.equals("stick your hand in")) {
                System.out.println("Something starts grabbing your hand and you cannot run away now...");
            }
        } else if (action.equals("go to the house")) {
            System.out.println("You are standing in front of the boarded white door.");
            System.out.println("On the door are some creepy handprints and seemingly bloodstains.");
            System.out.println("Open the door, or run away?");
            action = userInput.nextLine();

            if (action.equals("open the door")) {
                System.out.println("A gust of chilly wind swipes your face. Before you know it, you are hanging on the tree...");
            } else if (action.equals("run away")) {
                System.out.println("You look foolish but that saved your life.");
            }
        } else {
            System.out.println("You walked to the lake along a dark path");
            System.out.println("The lake is completely dark and a reflection of the full moon is clear.");
            System.out.println("Look at your reflection, or run away?");
            action = userInput.nextLine();

            if (action.equals("look at reflection")) {
                System.out.println("Something pulls you into the water and you died.");
            } else if (action.equals("run away")) {
                System.out.println("Cowardice has saved your life.");
            }
        }
    }
}