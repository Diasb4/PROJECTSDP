package processor;

import Meals.Meal;
import strategy.PaymentStrategy;

public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public PaymentProcessor() {
    }

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public boolean processOrderPayment(Meal meal) {
        if (paymentStrategy == null) {
            System.out.println("✗ No payment method selected!");
            return false;
        }

        if (meal == null) {
            System.out.println("✗ No meal provided for payment!");
            return false;
        }

        double totalAmount = meal.getCost();
        System.out.println("\n=== Processing Payment ===");
        System.out.println("Meal: " + meal.getDescription());
        System.out.println("Total amount: €" + String.format("%.2f", totalAmount));
        System.out.println("Payment method: " + paymentStrategy.getPaymentMethodName());
        System.out.println("Details: " + paymentStrategy.getPaymentDetails());

        return paymentStrategy.processPayment(totalAmount);
    }

    public String getCurrentPaymentMethod() {
        return paymentStrategy != null ? paymentStrategy.getPaymentMethodName() : "No method selected";
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }
}