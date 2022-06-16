package exercises.refactorintoobjects;
/* Created by limxuanhui on 14/6/22 */

import java.util.ArrayList;
import java.util.Scanner;

class Factorizer {
    public ArrayList<Integer> factorize(int num) {
        ArrayList<Integer> factors = new ArrayList<>();

        // check up to half of num as num/2 + 1 will not be a factor
        for (int i = 1; i <= num/2; i++) {
            if (num % i == 0) {
                factors.add(i);
            }
        }
        // add num as a factor to itself
        factors.add(num);
        return factors;
    }

    public boolean isPerfectNumber(ArrayList<Integer> factors) {
        int factorsSum = 0;
        for (int i = 0; i < factors.size() - 1; i++) {
            factorsSum += factors.get(i);
        }

        // checks if sum of factors excluding num itself, equals num
        return factorsSum == factors.get(factors.size()-1);
    }

    public void analyse(int num) {
        ArrayList<Integer> factors = factorize(num);
        boolean isPerfectNumber = isPerfectNumber(factors);

        // is prime number if the only factors are 1 and num itself
        boolean isPrimeNumber = factors.size() == 2;

        System.out.println("The factors of " + num + " are:");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();
        System.out.println(num + " is " + (isPerfectNumber ? "a" : "not a") + " perfect number.");
        System.out.println(num + " is " + (isPrimeNumber ? "a" : "not a") + " prime number.");
    }

    public void startFactorize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What number would you like to factor?");
        int num = scanner.nextInt();
        analyse(num);
    }
}

public class FactorizerRefactor {
    public static void main(String[] args) {
        Factorizer factorizer = new Factorizer();
        factorizer.startFactorize();
    }
}