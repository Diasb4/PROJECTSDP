package Decorator;

import interfaces.IMeal;

public abstract class SauceDecorator extends MealDecorator {
    private String sauceType;
    private float sauceCost;

    public SauceDecorator(IMeal meal, String sauceType, float cost) {
        super(meal);
        this.sauceType = sauceType;
        this.sauceCost = cost;
    }

    @Override
    public String getDescription() {
        return decoratedMeal.getDescription() + " + " + sauceType + " Sauce";
    }

    @Override
    public float getPrice() {
        return decoratedMeal.getPrice() + sauceCost;
    }

    public String getSauceType() {
        return sauceType;
    }

    public double getSauceCost() {
        return sauceCost;
    }
}