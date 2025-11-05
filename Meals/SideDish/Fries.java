package Meals.SideDish;

import Config.RestaurantOrderConfig;
import interfaces.IMeal;

public class Fries implements IMeal {
    @Override
    public String getDescription() {
        return RestaurantOrderConfig.FRIES;
    }

    @Override
    public float getPrice() {
        return RestaurantOrderConfig.FRIES_PRICE;
    }

    @Override
    public void serve() {
        System.out.println("Serving a " + getDescription() + "!");
    }

}
