package exercises.flowcontrols.ifs;
/* Created by limxuanhui on 20/6/22 */

import java.util.Scanner;

public class TriviaNight {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int correctCount = 0;
        System.out.println("It's TRIVIA NIGHT! Are you ready?!");

        System.out.println("FIRST QUESTION!");
        System.out.println("What is the Lowest Level Programming Language?");
        System.out.println("1) Source Code \t" + "\t 2) Assembly Language");
        System.out.println("3) C# \t" + "\t 4) Machine Code");
        int answer = scanner.nextInt();
        System.out.println("YOUR ANSWER: " + answer);
        if (answer == 4) {
            System.out.println("You are correct! Your current score is " + ++correctCount);
        } else {
            System.out.println("Oh no, that's incorrect. The correct answer is 4) Machine Code.");
        }

        System.out.println("SECOND QUESTION!");
        System.out.println("Website Security CAPTCHA Forms Are Descended From the Work of?");
        System.out.println("1) Grace Hopper \t" + "\t 2) Alan Turing");
        System.out.println("3) Charles Babbage \t" + "\t 4) Larry Page");
        answer = scanner.nextInt();
        if (answer == 2) {
            System.out.println("You are correct! Your current score is " + ++correctCount);
        } else {
            System.out.println("Oh no, that's incorrect. The correct answer is 2) Alan Turing.");
        }

        System.out.println("LAST QUESTION!");
        System.out.println("Which of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?");
        System.out.println("1) Serenity \t" + "\t 2) The Battlestar Galactica");
        System.out.println("3) The USS Enterprise \t" + "\t 4) The Millenium Falcon");
        answer = scanner.nextInt();
        if (answer == 3) {
            System.out.println("You are correct! Your current score is " + ++correctCount);
        } else {
            System.out.println("Oh no, that's incorrect. The correct answer is 3) The USS Enterprise.");
        }

        if (correctCount >= 2) {
            System.out.println("Nice job - you got " + correctCount + " correct!");
        } else {
            System.out.println("Oh no - you got " + correctCount + " correct...");
        }


    }
}
