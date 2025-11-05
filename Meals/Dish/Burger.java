package Meals.Dish;

import Config.RestaurantOrderConfig;
import interfaces.IMeal;

public class Burger implements IMeal {
    @Override
    public String getDescription() {
        return RestaurantOrderConfig.BURGER;
    }

    @Override
    public float getPrice() {
        return RestaurantOrderConfig.BURGER_PRICE;
    }

    @Override
    public void serve() {
        System.out.println("Serving a" + getDescription() + "!");
    }
}
