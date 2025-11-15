package Meals.Dish;

import Visitor.MealVisitor;
import interfaces.IMeal;

public class Lasagna implements IMeal {
    private String description = "Lasagna";
    private float price = 10.49f;
    private int CookingTime=15;

    @Override
    public int getCookingTime() {
        return CookingTime;
    }

    public void setCookingTime(int cookingTime) {
        CookingTime = cookingTime;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public void serve() {
        System.out.println("Serving a " + description + "!");
    }
    @Override
    public void accept(MealVisitor visitor) {
        visitor.visit(this);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
