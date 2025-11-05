import Factory.MealFactory;
import interfaces.IMeal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Restaurant Order System!");
        System.out.println("We have Pizza, Burger, and Salad.");
        // Инициализация сканера, фабрики и списка заказов
        Scanner scanner = new Scanner(System.in);
        MealFactory factory = new MealFactory();
        List<IMeal> orders = new ArrayList<>();

        boolean ordering = true;
        while (ordering) {
            System.out.println("What would you like to order?");
            String input = scanner.nextLine();

            try {
                IMeal meal = factory.createDish(input);
                orders.add(meal);
                System.out.println(meal.getDescription() + " added to your order.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Please try again.");
                continue; // просим пользователя ввести заново
            }

            System.out.println("Anything else? (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes") && !response.equals("y")) {
                ordering = false;
            }
        }
        // Вывод итогового заказа
        System.out.println("Ordered Items:");
        double total = 0;
        for (IMeal item : orders) {
            System.out.println(item.getDescription() + " - $" + item.getPrice());
            total += item.getPrice();
        }
        System.out.printf("Total: $%.2f%n", total);
        System.out.println("Thank you for your order!");

        scanner.close();
    }
}
