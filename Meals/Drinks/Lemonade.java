package Meals.Drinks;

import interfaces.IMeal;

public class Lemonade implements IMeal {
    private final String description = "Lemonade";
    private final float price = 1.75f;

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
