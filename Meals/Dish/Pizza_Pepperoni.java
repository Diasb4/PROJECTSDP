package Meals.Dish;

import interfaces.IMeal;

public class Pizza_Pepperoni implements IMeal {
    private final String description = "Pizza Pepperoni";
    private final float price = 9.99f;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public float getPrice() {
        return price;
    }

    public String toString() {
        return getDescription() + " - " + getPrice();
    }

    @Override
    public void serve() {
        System.out.println("Serving a" + getDescription() + "!");
    }

}
