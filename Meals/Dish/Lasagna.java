package Meals.Dish;

import interfaces.IMeal;

public class Lasagna implements IMeal {
    private final String description = "Lasagna";
    private final float price = 10.49f;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public void serve() {
        System.out.println("Serving a " + description + "!");
    }
}
