package Decorator;

import interfaces.IMeal;

public abstract class BeverageDecorator extends MealDecorator {
    private String beverageType;
    private float beverageCost;

    public BeverageDecorator(IMeal meal, String beverageType, float cost) {
        super(meal);
        this.beverageType = beverageType;
        this.beverageCost = cost;
    }

    @Override
    public String getDescription() {
        return decoratedMeal.getDescription() + " + " + beverageType;
    }

    @Override
    public float getPrice() {
        return decoratedMeal.getPrice() + beverageCost;
    }

    public String getBeverageType() {
        return beverageType;
    }

    public double getBeverageCost() {
        return beverageCost;
    }
}