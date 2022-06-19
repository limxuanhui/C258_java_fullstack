package L9.BankingBackendApp;
/* Created by limxuanhui on 17/6/22 */

public class BankAccount {
    private String accountHolderName;
    private long accountNumber;
    private double accountBalance;

    public BankAccount(String accountHolderName, long accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.accountBalance = 0;
    }

    public BankAccount(String accountHolderName, long accountNumber, double accountBalance) {
        this(accountHolderName, accountNumber);
        this.accountBalance = accountBalance;
    }
}
