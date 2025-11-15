package Meals.Desserts;

import Visitor.MealVisitor;
import interfaces.IMeal;

public class Gelato implements IMeal {
    private String Gelato = "Gelato";
    private float Gelato_Price = 3.00f;
    private int CookingTime=7;

    @Override
    public int getCookingTime() {
        return CookingTime;
    }

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

    public void setGelato(String gelato) {
        Gelato = gelato;
    }

    public void setGelato_Price(float gelato_Price) {
        Gelato_Price = gelato_Price;
    }

    public void setCookingTime(int cookingTime) {
        CookingTime = cookingTime;
    }

    @Override
    public void accept(MealVisitor visitor) {
        visitor.visit(this);
    }
}
