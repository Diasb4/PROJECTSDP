import Orders.OrderBuilder;
import Orders.Order;
import interfaces.IMeal;
import java.util.*;

import Meals.Dish.*;
import Meals.Desserts.*;
import Meals.Drinks.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Restaurant Order System!");
        System.out.println("Menu:");

        List<IMeal> menu = List.of(
                new Pizza_Margherita(),
                new Pizza_Pepperoni(),
                new Lasagna(),
                new Gelato(),
                new Tiramisu(),
                new Coke(),
                new Lemonade(),
                new Water());

        for (IMeal meal : menu) {
            System.out.printf("- %-20s : $%.2f%n", meal.getDescription(), meal.getPrice());
        }

        Scanner scanner = new Scanner(System.in);
        OrderBuilder builder = new OrderBuilder();

        while (true) {
            System.out.println("\nEnter item name to add (or 'done' to finish):");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("done"))
                break;

            Optional<IMeal> selected = menu.stream()
                    .filter(m -> m.getDescription().toLowerCase().equals(input))
                    .findFirst();

            if (selected.isPresent()) {
                IMeal meal = selected.get();
                if (meal instanceof Meals.Dish.Lasagna || meal instanceof Meals.Dish.Pizza_Margherita
                        || meal instanceof Meals.Dish.Pizza_Pepperoni) {
                    builder.setMainDish(meal.getDescription());
                } else if (meal instanceof Meals.Desserts.Gelato || meal instanceof Meals.Desserts.Tiramisu) {
                    builder.setDessert(meal.getDescription());
                } else if (meal instanceof Meals.Drinks.Coke || meal instanceof Meals.Drinks.Lemonade
                        || meal instanceof Meals.Drinks.Water) {
                    builder.setDrink(meal.getDescription());
                } else {
                    builder.addSide(meal.getDescription());
                }
                System.out.println(meal.getDescription() + " added!");
            } else {
                System.out.println("Sorry, we don’t have that item.");
            }
        }

        Order order = builder.build();
        System.out.println();
        order.showOrder();

        scanner.close();
    }
}
