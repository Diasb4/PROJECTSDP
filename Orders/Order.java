package Orders;

import interfaces.IMeal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private IMeal mainDish;
    private final List<IMeal> sides = new ArrayList<>();
    private IMeal drink;
    private IMeal dessert;

    public void setMainDish(IMeal mainDish) {
        this.mainDish = mainDish;
    }

    public void addSide(IMeal side) {
        sides.add(side);
    }

    public void setDrink(IMeal drink) {
        this.drink = drink;
    }

    public void setDessert(IMeal dessert) {
        this.dessert = dessert;
    }

    public IMeal getMainDish() {
        return mainDish;
    }

    public List<IMeal> getSides() {
        return sides;
    }

    public IMeal getDrink() {
        return drink;
    }

    public IMeal getDessert() {
        return dessert;
    }

    public double getTotalPrice() {
        double total = 0;
        if (mainDish != null)
            total += mainDish.getPrice();
        for (IMeal side : sides)
            total += side.getPrice();
        if (drink != null)
            total += drink.getPrice();
        if (dessert != null)
            total += dessert.getPrice();
        return total;
    }

    public void showOrder() {
        System.out.println("\nYour Order:");
        if (mainDish != null)
            System.out.println("Main Dish: " + mainDish.getDescription() + " - $" + mainDish.getPrice());
        for (IMeal side : sides)
            System.out.println("Side: " + side.getDescription() + " - $" + side.getPrice());
        if (drink != null)
            System.out.println("Drink: " + drink.getDescription() + " - $" + drink.getPrice());
        if (dessert != null)
            System.out.println("Dessert: " + dessert.getDescription() + " - $" + dessert.getPrice());
        System.out.printf("Total: $%.2f%n", getTotalPrice());
    }

    public List<IMeal> getAllMeals() {
        List<IMeal> allMeals = new ArrayList<>();
        if (mainDish != null)
            allMeals.add(mainDish);
        allMeals.addAll(sides);
        if (drink != null)
            allMeals.add(drink);
        if (dessert != null)
            allMeals.add(dessert);
        return allMeals;
    }
}
