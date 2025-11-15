import Orders.OrderBuilder;
import Decorator.Concrete_Decorator.*;
import Orders.Order;
import Visitor.CookingTimeVisitor;
import strategy.PaymentStrategy;
import strategy.concrete_strategy.CardPayment;
import strategy.concrete_strategy.CashPayment;
import strategy.concrete_strategy.QRPayment;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Restaurant Order System!");

        // Создаём заказ без Scanner
        OrderBuilder builder = new OrderBuilder();

        // Пример заказа
        builder.setMainDish("lasagna");// Главное блюдо
        builder.setDrink("water"); // Напиток
        builder.setDessert("tiramisu");// Дессерт
        builder.addSide("pizza margherita"); // Доп. Блюдо

        // Собираем заказ
        Order order = builder.build();

        order.showOrder();
        CookingTimeVisitor visitor = new CookingTimeVisitor();
        order.getAllMeals().forEach(IMeal -> IMeal.accept(visitor));
        System.out.println("Total cooking time: " + visitor.getTotalTime() + "min");

        OrderBuilder builder2 = new OrderBuilder();

        builder2.setMainDish("Pizza Pepperoni");
        builder2.addSide("Pizza Margherita");
        builder2.addSide("Pizza Margherita");

        Order order2 = builder2.build();
        order2.showOrder();
        CookingTimeVisitor visitor1 = new CookingTimeVisitor();
        order2.getAllMeals().forEach(IMeal -> IMeal.accept(visitor1));
        System.out.println("Total cooking time: " + visitor1.getTotalTime() + "min");

        OrderBuilder builder3 = new OrderBuilder();

        builder3.setMainDish("Pizza Margherita");
        builder3.addDecoratorToMain(meal -> new CheeseAddon(meal, "Mozzarella", 2.0f));

        Order order3 = builder3.build();
        double totalAmount = order3.getTotalPrice();
        PaymentStrategy payment = new CardPayment("1856948045875635", "S", "11/1", "458");
        boolean success = payment.processPayment(totalAmount);
        PaymentStrategy payment2 = new CashPayment(totalAmount);

        order3.showOrder();
        CookingTimeVisitor visitor2 = new CookingTimeVisitor();
        order3.getAllMeals().forEach(IMeal -> IMeal.accept(visitor2));

        if (success) {
            System.out.println("Payment successful via " + payment.getPaymentMethodName());
        } else {
            System.out.println("Payment failed via " + payment.getPaymentMethodName());
        }
        if (success) {
            System.out.println("Payment successful via " + payment2.getPaymentMethodName());
        } else {
            System.out.println("Payment failed via " + payment2.getPaymentMethodName());
        }
        System.out.println("Total cooking time: " + visitor2.getTotalTime() + "min");

        OrderBuilder builder4 = new OrderBuilder();

        // Декорируем главное блюдо
        builder4.addDecoratorToMain(meal -> new CheeseAddon(meal, "Parmesan", 2.0f));

        // Декорируем гарнир
        builder4.addDecoratorToSide(meal -> new ToppingAddon(meal, "Olives", 1.5f));

        // Декорируем напиток
        builder4.addDecoratorToDrink(meal -> new ToppingAddon(meal, "Lemon", 0.5f));

        // Устанавливаем блюда
        builder4.setMainDish("Pizza Margherita");
        builder4.addSide("Lasagna");
        builder4.setDrink("Water");
        builder4.setDessert("Tiramisu");

        boolean success3 = payment.processPayment(totalAmount);
        PaymentStrategy payment3 = new QRPayment("QR1584789631844");

        Order order4 = builder4.build();
        order4.showOrder();
        if (success3) {
            System.out.println("Payment successful via " + payment3.getPaymentMethodName());
        } else {
            System.out.println("Payment failed via " + payment3.getPaymentMethodName());
        }
    }

}
