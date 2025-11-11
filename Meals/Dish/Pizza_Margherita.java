package Meals.Dish;

import interfaces.IMeal;

public class Pizza_Margherita implements IMeal {
    private final String description = "Pizza Margherita";
    private final float price = 8.99f;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public float getPrice() {
        return price;
    }

    public String toString() {
        return getDescription() + " - $" + getPrice();
    }

    @Override
    public void serve() {
        System.out.println("Serving a" + getDescription() + "!");
    }
}
