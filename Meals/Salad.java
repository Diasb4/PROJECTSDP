package Meals;

import Config.RestaurantOrderConfig;
import interfaces.IMeal;

public class Salad implements IMeal {
    @Override
    public String getDescription() {
        return RestaurantOrderConfig.SALAD;
    }

    @Override
    public float getPrice() {
        return RestaurantOrderConfig.SALAD_PRICE;
    }

    @Override
    public void serve() {
        System.out.println("Serving a " + getDescription() + "!");
    }
}
