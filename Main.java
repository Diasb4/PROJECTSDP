import Orders.OrderBuilder;
import interfaces.IMeal;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Meals.Dish.Pizza;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Restaurant Order System!");
        System.out.println("We have Pizza, Burger, and Salad.");

        Scanner scanner = new Scanner(System.in);
        OrderBuilder builder = new OrderBuilder();

        boolean ordering = true;
        while (ordering) {
            System.out.println("What would you like to order?");
            String input = scanner.nextLine();

            try {
                builder.addDish(input);
                System.out.println(input + " added to your order.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Please try again.");
                continue;
            }

            System.out.println("Anything else? (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes") && !response.equals("y")) {
                ordering = false;
            }
        }

        // Получаем готовый заказ
        List<IMeal> orders = builder.build();

        System.out.println("Ordered Items:");
        for (IMeal meal : orders) {
            System.out.println(meal.getDescription() + " - $" + meal.getPrice());
        }
        System.out.printf("Total: $%.2f%n", builder.getTotalPrice());
        // Демонстрация использования нового билдера
        OrderBuilder newBuilder = new OrderBuilder();
        newBuilder.addDish("pizza")
                .addDish("fries")
                .addDish("coke")
                .addDish("icecream");

        System.out.printf(Locale.US, "New Order Total: $%.2f%n", newBuilder.getTotalPrice());

        scanner.close();
    }
}
