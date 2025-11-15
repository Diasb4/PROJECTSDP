package Decorator;

import Decorator.MealDecorator;
import interfaces.IMeal;

public abstract class ExtraToppingDecorator extends MealDecorator {
    private String toppingName;
    private float toppingCost;

    public ExtraToppingDecorator(IMeal meal, String toppingName, float cost) {
        super(meal);
        this.toppingName = toppingName;
        this.toppingCost = cost;
    }

    @Override
    public String getDescription() {
        return decoratedMeal.getDescription() + " + Extra " + toppingName;
    }

    @Override
    public float getPrice() {
        return decoratedMeal.getPrice() + toppingCost;
    }

    public String getToppingName() {
        return toppingName;
    }

    public double getToppingCost() {
        return toppingCost;
    }
}