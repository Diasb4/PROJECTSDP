package Meals.Drinks;

import Config.RestaurantOrderConfig;
import interfaces.IMeal;

public class Coke implements IMeal {
    @Override
    public String getDescription() {
        return RestaurantOrderConfig.COKE;
    }

    @Override
    public float getPrice() {
        return RestaurantOrderConfig.COKE_PRICE;
    }

    @Override
    public void serve() {
        System.out.println("Serving a " + getDescription() + "!");
    }

}
