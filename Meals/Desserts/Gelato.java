package Meals.Desserts;

import interfaces.IMeal;

public class Gelato implements IMeal {
    private final String Gelato = "Gelato";
    private final float Gelato_Price = 3.00f;

    @Override
    public String getDescription() {
        return Gelato;
    }

    @Override
    public float getPrice() {
        return Gelato_Price;
    }

    @Override
    public void serve() {
        System.out.println("Serving a " + getDescription() + "!");
    }

}
