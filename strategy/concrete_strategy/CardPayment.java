package strategy.concrete_strategy;

import strategy.PaymentStrategy;

public class CardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;
    private String expiryDate;
    private String cvv;

    public CardPayment(String cardNumber, String cardHolder, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public boolean processPayment(double amount) {
        if (isValidCard()) {
            System.out.println("Card payment processed successfully! Amount: $" + String.format("%.2f", amount));
            System.out.println("  Card: **** **** **** " + cardNumber.substring(cardNumber.length() - 4));
            return true;
        } else {
            System.out.println("Card payment failed! Please check card details.");
            return false;
        }
    }

    @Override
    public String getPaymentMethodName() {
        return "Credit/Debit Card";
    }

    @Override
    public String getPaymentDetails() {
        return "Card: **** **** **** " + cardNumber.substring(cardNumber.length() - 4) +
                ", Holder: " + cardHolder;
    }

    private boolean isValidCard() {
        return cardNumber != null && cardNumber.length() == 16 &&
                cardHolder != null && !cardHolder.trim().isEmpty() &&
                cvv != null && cvv.length() == 3;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
}