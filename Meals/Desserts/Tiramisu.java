package Meals.Desserts;

import Visitor.MealVisitor;
import interfaces.IMeal;

public class Tiramisu implements IMeal {
    private String Tiramisu = "Tiramisu";
    private float Tiramisu_Price = 3.50f;
    private int CookingTime=5;

    @Override
    public int getCookingTime() {
        return CookingTime;
    }

    public void setCookingTime(int cookingTime) {
        CookingTime = cookingTime;
    }

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

    public void setTiramisu(String tiramisu) {
        Tiramisu = tiramisu;
    }

    public void setTiramisu_Price(float tiramisu_Price) {
        Tiramisu_Price = tiramisu_Price;
    }
    @Override
    public void accept(MealVisitor visitor) {
        visitor.visit(this);
    }
}
