package Meals.Drinks;

import interfaces.IMeal;

public class Water implements IMeal {
    private final String description = "Water";
    private final float price = 1.0f;

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
        System.out.println("Serving a " + getDescription() + "!");
    }

}
