package Meals;

import Config.RestaurantOrderConfig;
import interfaces.IMeal;

public class Pizza implements IMeal {
    private final String description;
    private final float price;

    public Pizza() {
        this.description = RestaurantOrderConfig.PIZZA;
        this.price = RestaurantOrderConfig.PIZZA_PRICE;
    }

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
