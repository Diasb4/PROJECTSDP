package Meals.Drinks;

import Visitor.MealVisitor;
import interfaces.IMeal;

public class Water implements IMeal {
    private String description = "Water";
    private float price = 1.0f;
    private int CookingTime=3;

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
        System.out.println("Serving a " + getDescription() + "!");
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
