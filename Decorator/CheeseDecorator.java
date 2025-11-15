package Decorator;

import interfaces.IMeal;

public abstract class CheeseDecorator extends MealDecorator {
    private String cheeseType;
    private float cheeseCost;

    public CheeseDecorator(IMeal meal, String cheeseType, float cost) {
        super(meal);
        this.cheeseType = cheeseType;
        this.cheeseCost = cost;
    }

    @Override
    public String getDescription() {
        return decoratedMeal.getDescription() + " + Extra " + cheeseType;
    }

    @Override
    public float getPrice() {
        return decoratedMeal.getPrice() + cheeseCost;
    }

    public String getCheeseType() {
        return cheeseType;
    }

    public double getCheeseCost() {
        return cheeseCost;
    }
}