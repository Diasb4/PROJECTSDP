package strategy;

public interface PaymentStrategy {
    boolean processPayment(double amount);

    String getPaymentMethodName();

    String getPaymentDetails();
}