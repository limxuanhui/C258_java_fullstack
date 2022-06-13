package assessments.basicprogrammingconcepts;
/* Created by limxuanhui on 10/6/22 */

import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    /*
      Write a program that plays the game Rock, Paper, Scissors.
    */

    private static Scanner scanner = new Scanner(System.in);
    private static Random randomNumber = new Random();
    private static final HashMap<Integer, String> ROCK_PAPER_SCISSORS_MAP = new HashMap<Integer, String>() {{
        put(1, "Rock");
        put(2, "Paper");
        put(3, "Scissors");
    }};

    private static int promptInteger() {
        boolean isValid = false;
        do {
            try {
                String so = scanner.nextLine();
                int number = Integer.parseInt(so);
                return number;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number, please try again.");
            }
        } while (!isValid);
        return -1;
    }

    private static boolean promptYesNo() {
        System.out.println("\tY or N?");
        String yesOrNo = scanner.nextLine();
        boolean isYes = yesOrNo.toLowerCase(Locale.ROOT).charAt(0) != 'n';
        return isYes;
    }

    private static boolean promptPlayAgain() {
        System.out.println("\tPlay again?");
        boolean playAgain = promptYesNo();
        return playAgain;
    }

    private static void generateScoreSheet(int computerWinCount, int userWinCount, int tieCount) {
        System.out.println("===== Scoresheet =====");
        System.out.println("Computer win: " + computerWinCount);
        System.out.println("User win: " + userWinCount);
        System.out.println("Ties: " + tieCount);
        String message = computerWinCount > userWinCount ? "Computer wins!" : userWinCount > computerWinCount ? "User wins!" : "It's a draw!";
        System.out.println(message);
    }

    private static int playRound(int userChoice, int computerChoice) {
        switch (userChoice) {
            case 1:
                System.out.println("\tYou played " + ROCK_PAPER_SCISSORS_MAP.get(1));
                if (computerChoice == 2) {
                    System.out.println("\tComputer played " + ROCK_PAPER_SCISSORS_MAP.get(2));
                    System.out.println("\tComputer wins this round!");
                    return 1;
                } else if (computerChoice == 3) {
                    System.out.println("\tComputer played " + ROCK_PAPER_SCISSORS_MAP.get(3));
                    System.out.println("\tYou win this round!");
                    return 2;
                } else {
                    System.out.println("\tComputer played " + ROCK_PAPER_SCISSORS_MAP.get(1));
                    System.out.println("\tIt's a tie!");
                    return 3;
                }
            case 2:
                System.out.println("\tYou played " + ROCK_PAPER_SCISSORS_MAP.get(2));
                if (computerChoice == 3) {
                    System.out.println("\tComputer played " + ROCK_PAPER_SCISSORS_MAP.get(3));
                    System.out.println("\tComputer wins this round!");
                    return 1;
                } else if (computerChoice == 1) {
                    System.out.println("\tComputer played " + ROCK_PAPER_SCISSORS_MAP.get(1));
                    System.out.println("\tYou win this round!");
                    return 2;
                } else {
                    System.out.println("\tComputer played " + ROCK_PAPER_SCISSORS_MAP.get(2));
                    System.out.println("\tIt's a tie!");
                    return 3;
                }
            case 3:
                System.out.println("\tYou played " + ROCK_PAPER_SCISSORS_MAP.get(3));
                if (computerChoice == 1) {
                    System.out.println("\tComputer played " + ROCK_PAPER_SCISSORS_MAP.get(1));
                    System.out.println("\tComputer wins this round!");
                    return 1;
                } else if (computerChoice == 2) {
                    System.out.println("\tComputer played " + ROCK_PAPER_SCISSORS_MAP.get(2));
                    System.out.println("\tYou win this round!");
                    return 2;
                } else {
                    System.out.println("\tComputer played " + ROCK_PAPER_SCISSORS_MAP.get(3));
                    System.out.println("\tIt's a tie!");
                    return 3;
                }
        }
        return 0;
    }

    private static void playRockPaperScissors(int numberOfTimes) {
        int computerWinCount = 0;
        int userWinCount = 0;
        int tieCount = 0;
        for (int i = 0; i < numberOfTimes; i++) {
            // Computer randomly chooses between 1 (Rock), 2 (Paper), 3 (Scissors)
            int computerChoice = randomNumber.nextInt(3) + 1;

            displayOptions();
            int userChoice = 0;
            while (userChoice < 1 || userChoice > 3) {
                userChoice = promptInteger();
            }

            int state = playRound(userChoice, computerChoice);
            if (state == 1) computerWinCount++;
            else if (state == 2) userWinCount++;
            else if (state == 3) tieCount++;
        }
        generateScoreSheet(computerWinCount, userWinCount, tieCount);
    }

    private static void displayOptions() {
        System.out.println("What will you play?");
        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");
    }

    public static void main(String[] args) {
        do {
            System.out.println("How many rounds do you want to play?");
            int numberOfTimes = promptInteger();
            playRockPaperScissors(numberOfTimes);

            if (!promptPlayAgain()) {
                System.out.println("Thanks for playing!");
                break;
            }
        } while (true);
    }
}
