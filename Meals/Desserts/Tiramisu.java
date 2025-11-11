package Meals.Desserts;

import interfaces.IMeal;

public class Tiramisu implements IMeal {
    private final String Tiramisu = "Tiramisu";
    private final float Tiramisu_Price = 3.50f;

    @Override
    public String getDescription() {
        return Tiramisu;
    }

    @Override
    public float getPrice() {
        return Tiramisu_Price;
    }

    @Override
    public void serve() {
        System.out.println("Serving a " + getDescription() + "!");
    }

}
