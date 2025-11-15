package Meals.Dish;

import Visitor.MealVisitor;
import interfaces.IMeal;

public class Pizza_Margherita implements IMeal {
    private String description = "Pizza Margherita";
    private float price = 8.99f;
    private int CookingTime=12;

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

    public String toString() {
        return getDescription() + " - $" + getPrice();
    }

    @Override
    public void serve() {
        System.out.println("Serving a" + getDescription() + "!");
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
