package L9.BankingBackendApp;
/* Created by limxuanhui on 16/6/22 */

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bank {
    private static final String DATABASE_URL = "src/L9/BankingBackendApp/creditcarddatabase.txt";
    private static Scanner scanner = new Scanner(System.in);
    private ArrayList<CreditCard> creditCards;

    public Bank() {
        this.creditCards = new ArrayList<>();
        boolean connectedToDatabase;
        do {
            connectedToDatabase = connectToDatabase(DATABASE_URL);
        } while (!connectedToDatabase);

        greet();
        displayCreditCardOptions();
        int choice = promptInt();
        while (choice >= 1 && choice <= 6) {
            serve(choice);
            if (choice == 6) break;
            displayCreditCardOptions();
            choice = promptInt();
        }
    }

    public static int promptInt() {
        boolean isValidInt = false;
        do {
            try {
                String sInt = scanner.nextLine();
                int num = Integer.parseInt(sInt);
                return num;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number, please try again");
            }
        } while (!isValidInt);
        return -1;
    }

    public static String promptString(String field) {
        System.out.println("Enter your " + field);
        String enteredField = scanner.nextLine();
        return enteredField;
    }

    private void serve(int choice) {
        switch (choice) {
            case 1:
                String cardHolderName = promptString("name");
                CreditCard newCreditCard = signUpForCreditCard(cardHolderName);
                this.creditCards.add(newCreditCard);
                System.out.println("Credit card signup success! Your new card is:");
                System.out.println(newCreditCard);
                break;
            case 2:
                cardHolderName = promptString("name");
                ArrayList<CreditCard> userCreditCards = getAllMyCreditCards(cardHolderName);
                if (userCreditCards.size() == 0) {
                    System.out.println("No cards found under your name");
                } else {
                    for (CreditCard card : userCreditCards) {
                        System.out.println(card);
                    }
                }
                break;
            case 3:
                cardHolderName = promptString("name");
                String cardNumber = promptString("card number");
                LocalDate cardExpiryDate = getCardExpiry(cardHolderName, cardNumber);
                if (cardExpiryDate == null) {
                    System.out.println("No such card found");
                } else {
                    System.out.println("Card expiry date: " + cardExpiryDate);
                }
                break;
            case 4:
                cardHolderName = promptString("name");
                cardNumber = promptString("card number");
                LocalDate newCardExpiryDate = renewCard(cardHolderName, cardNumber);
                if (newCardExpiryDate == null) {
                    System.out.println("No such card found");
                } else {
                    System.out.println("New card expiry date: " + newCardExpiryDate);
                }
                break;
            case 5:
                cardHolderName = promptString("name");
                cardNumber = promptString("card number");
                boolean cardCancelled = cancelCard(cardHolderName, cardNumber);
                if (cardCancelled) {
                    System.out.println("You card number " + cardNumber + " has been successfully terminated");
                } else {
                    System.out.println("No such card found");
                }
                break;
            case 6:
                // save all credit cards to database (should not be overwriting all data everytime)
                saveToDatabase(DATABASE_URL);
                bye();
                break;
        }
    }

    private boolean connectToDatabase(String url) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(url);
        } catch (FileNotFoundException e) {
            System.out.println("File is not found at the specified url");
            return false;
        }

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        try {
            // load in all the credit card details from database
            while ((line = bufferedReader.readLine()) != null) {
                String[] cardDetails = line.split(",");
                if (cardDetails.length == 4) {
                    CreditCard newCreditCard = new CreditCard(cardDetails[0], cardDetails[1], cardDetails[2], cardDetails[3]);
                    this.creditCards.add(newCreditCard);
                }
            }
        } catch (IOException e) {
            System.out.println("Something went wrong while connecting to the database");
            return false;
        }

        // readers.close()
        try {
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Something went wrong while closing connection to database");
        }

        return true;
    }

    private void saveToDatabase(String url) {
        System.out.println("Saving....");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(url);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (CreditCard creditCard : creditCards) {
            String l = creditCard.getCardHolderName() + ","
                        + creditCard.getCardNumber()+ ","
                        + creditCard.getCreationDate() + ","
                        + creditCard.getExpiryDate();
            System.out.println("Saving this to database: " + l);
            try {
                bufferedWriter.write(l);
                bufferedWriter.newLine();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void greet() {
        System.out.println("Welcome to Bank of Joseph");
        System.out.println("How may I help you?");
    }

    private static void bye() {
        System.out.println("Bank of Joseph looks forward to serving you again!");
    }

    private static void displayCreditCardOptions() {
        System.out.println("\t1. Sign up for credit card");
        System.out.println("\t2. Check all my cards");
        System.out.println("\t3. Check card expiry");
        System.out.println("\t4. Renew credit card");
        System.out.println("\t5. Cancel credit card");
        System.out.println("\t6. Exit");
        System.out.println("What would you like to do today?");
    }

    /*
      CRUD operations
    */
    private CreditCard signUpForCreditCard(String cardHolderName) {
        return new CreditCard(cardHolderName);
    }

    private ArrayList<CreditCard> getAllCreditCards() {
        return creditCards;
    }

    private CreditCard getCreditCard(String cardHolderName, String cardNumber) {
        ArrayList<CreditCard> foundCreditCards = this.creditCards.stream()
                        .filter(card -> card.getCardHolderName().equals(cardHolderName)
                                        && card.getCardNumber() == Long.parseLong(cardNumber))
                        .collect(Collectors.toCollection(ArrayList::new));
        if (foundCreditCards.size() == 0) {
            return null;
        }
        return foundCreditCards.get(0);
    }

    private ArrayList<CreditCard> getAllMyCreditCards(String cardHolderName) {
        return this.creditCards.stream()
                               .filter(card -> card.getCardHolderName().equals(cardHolderName))
                               .collect(Collectors.toCollection(ArrayList::new));
    }

    private LocalDate getCardExpiry(String cardHolderName, String cardNumber) {
        CreditCard creditCard = getCreditCard(cardHolderName, cardNumber);
        if (creditCard == null) {
            return null;
        }
        return creditCard.getExpiryDate();
    }

    private boolean cardIsExpired(CreditCard card) {
        return card.getExpiryDate().isBefore(LocalDate.now());
    }

    private LocalDate renewCard(String cardHolderName, String cardNumber) {
        CreditCard creditCard = getCreditCard(cardHolderName, cardNumber);
        if (creditCard == null) {
            return null;
        } else {
            creditCard.setExpiryDate(LocalDate.now().plusYears(5).minusDays(1));
            return creditCard.getExpiryDate();
        }
    }

    private boolean cancelCard(String cardHolderName, String cardNumber) {
        CreditCard creditCard = getCreditCard(cardHolderName, cardNumber);
        return this.creditCards.remove(creditCard);
    }
}