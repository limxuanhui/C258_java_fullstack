package L9.BankingBackendApp;
/* Created by limxuanhui on 17/6/22 */

import java.util.TreeSet;

public class AccountNumberGenerator {
    private static long nextAvailableAccountNumber;

    public AccountNumberGenerator(TreeSet<CreditCard> creditCards) {
        nextAvailableAccountNumber = creditCards.last().getCardNumber() + 1;
    }

    public static long generateAccountNumber() {
        return nextAvailableAccountNumber++;
    }
}
