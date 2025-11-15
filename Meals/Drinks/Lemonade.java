package Meals.Drinks;

import Visitor.MealVisitor;
import interfaces.IMeal;

public class Lemonade implements IMeal {
    private String description = "Lemonade";
    private float price = 1.75f;
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
