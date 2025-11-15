package strategy.concrete_strategy;

import strategy.PaymentStrategy;

public class CashPayment implements PaymentStrategy {

    private double cashTendered;
    private double change;

    public CashPayment(double cashTendered) {
        this.cashTendered = cashTendered;
        this.change = 0;
    }

    @Override
    public boolean processPayment(double amount) {
        if (cashTendered >= amount) {
            change = cashTendered - amount;
            System.out.println("Cash payment successful! Amount: $" + String.format("%.2f", amount));
            if (change > 0) {
                System.out.println("  Change: $" + String.format("%.2f", change));
            }
            return true;
        } else {
            System.out.println("Insufficient cash! Required: $" + String.format("%.2f", amount) +
                    ", Provided: $" + String.format("%.2f", cashTendered));
            return false;
        }
    }

    @Override
    public String getPaymentMethodName() {
        return "Cash";
    }

    @Override
    public String getPaymentDetails() {
        return "Cash tendered: $" + String.format("%.2f", cashTendered);
    }

    public double getCashTendered() {
        return cashTendered;
    }
}
