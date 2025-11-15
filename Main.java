import Orders.OrderBuilder;
import Orders.Order;
import Visitor.CookingTimeVisitor;
import interfaces.IMeal;

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

        System.out.println("\nYour Order:");
        order.showOrder();
        CookingTimeVisitor visitor=new CookingTimeVisitor();
        order.getAllMeals().forEach(IMeal->IMeal.accept(visitor));
        System.out.println("Total cooking time: "+visitor.getTotalTime()+"min");

        OrderBuilder builder2 = new OrderBuilder();

        builder2.setMainDish("Pizza Pepperoni");
        builder2.addSide("Pizza Margherita");
        builder2.addSide("Pizza Margherita");

        Order order2 = builder2.build();
        System.out.println("\nYour Order:");
        order2.showOrder();
        CookingTimeVisitor visitor1=new CookingTimeVisitor();
        order2.getAllMeals().forEach(IMeal->IMeal.accept(visitor1));
        System.out.println("Total cooking time: "+visitor1.getTotalTime()+"min");

    }
}
