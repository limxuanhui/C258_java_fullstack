package exercises;
/* Created by limxuanhui on 13/6/22 */

import java.util.Scanner;

public class InterestCalculator {

    public static void generateYearlySummary(int yearNumber, double startAmount, double endAmount) {
        startAmount = (double) Math.round(startAmount*100.0)/100.0;
        endAmount = (double) Math.round(endAmount*100.0)/100.0;
        double interest = (double) Math.round((endAmount - startAmount)*100.0)/100.0;
        System.out.println("Year " + yearNumber);
        System.out.println("Began with $" + startAmount);
        System.out.println("Earned $" + interest);
        System.out.println("Ended with $" + endAmount);
        System.out.println();
    }

    public static void analyseInvestment(float principalAmount, int numberOfYears, float annualInterestRate, int numberOfCompounding) {
        System.out.println("Calculating...");

        double startAmount = principalAmount;
        float periodInterestRate = annualInterestRate / numberOfCompounding;
        for (int i = 1; i <= numberOfYears; i++) {
            float periodGrowthFactor = (1 + periodInterestRate/100);
            double endAmount = startAmount*Math.pow(periodGrowthFactor, numberOfCompounding);
            generateYearlySummary(i, startAmount, endAmount);
            startAmount = endAmount;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How much do you want to invest?");
        float principalAmount = scanner.nextFloat();
        System.out.println("How many years are investing?");
        int numberOfYears = scanner.nextInt();
        System.out.println("What is the annual interest rate % growth?");
        float annualInterestRate = scanner.nextFloat();
        System.out.println("Number of compounding per year?");
        int numberOfCompounding = scanner.nextInt();

        analyseInvestment(principalAmount, numberOfYears, annualInterestRate, numberOfCompounding);
    }
}
