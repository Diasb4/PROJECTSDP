package Meals.Desserts;

import Config.RestaurantOrderConfig;
import interfaces.IMeal;

public class IceCream implements IMeal {
    @Override
    public String getDescription() {
        return RestaurantOrderConfig.ICE_CREAM;
    }

    @Override
    public float getPrice() {
        return RestaurantOrderConfig.ICE_CREAM_PRICE;
    }

    @Override
    public void serve() {
        System.out.println("Serving a " + getDescription() + "!");
    }

}
