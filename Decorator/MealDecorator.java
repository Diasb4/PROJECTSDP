package Decorator;

import interfaces.IMeal;

public abstract class MealDecorator implements IMeal {
    protected IMeal decoratedMeal;

    public MealDecorator(IMeal meal) {
        this.decoratedMeal = meal;
    }

    @Override
    public String getDescription() {
        return decoratedMeal.getDescription();
    }

    @Override
    public float getPrice() {
        return decoratedMeal.getPrice();
    }
}