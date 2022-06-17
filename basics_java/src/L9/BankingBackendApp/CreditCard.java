package L9.BankingBackendApp;
/* Created by limxuanhui on 16/6/22 */

import java.time.LocalDate;
import java.util.Objects;

public class CreditCard implements BankingCard {
    private final String TYPE = "CREDIT";
    private final String cardHolderName;
    private final long cardNumber;
    private final LocalDate creationDate;
    private LocalDate expiryDate;

    public CreditCard(String cardHolderName) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = (long)(Math.random()*Math.pow(10,12));
        this.creationDate = LocalDate.now();
        this.expiryDate = this.creationDate.plusYears(5).minusDays(1);
    }

    public CreditCard(String cardHolderName, long cardNumber, LocalDate creationDate, LocalDate expiryDate) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.creationDate = creationDate;
        this.expiryDate = expiryDate;
    }

    public CreditCard(String cardHolderName, String cardNumber, String creationDate, String expiryDate) {
        this(cardHolderName, Long.parseLong(cardNumber), LocalDate.parse(creationDate), LocalDate.parse(expiryDate));
    }

    @Override
    public void swipeCard() {
        System.out.println("Swiping...");
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "CreditCard --- Card holder name: " + cardHolderName + " | Card number: " + cardNumber +
                " | Creation date: " + creationDate + " | Expiry date: " + expiryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return cardNumber == that.cardNumber && Objects.equals(cardHolderName, that.cardHolderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardHolderName, cardNumber);
    }
}
