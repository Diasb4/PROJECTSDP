package Decorator.Concrete_Decorator;

import Decorator.MealDecorator;
import interfaces.IMeal;
import Visitor.MealVisitor;

public class SauceAddon extends MealDecorator {

    private String sauceName;
    private float sauceCost;

    public SauceAddon(IMeal meal, String sauceName, float sauceCost) {
        super(meal);
        this.sauceName = sauceName;
        this.sauceCost = sauceCost;
    }

    @Override
    public String getDescription() {
        return decoratedMeal.getDescription() + " + " + sauceName + " Sauce";
    }

    @Override
    public float getPrice() {
        return decoratedMeal.getPrice() + sauceCost;
    }

    @Override
    public int getCookingTime() {
        return decoratedMeal.getCookingTime();
    }

    @Override
    public void accept(MealVisitor visitor) {
        decoratedMeal.accept(visitor);
    }

    @Override
    public void serve() {
        decoratedMeal.serve(); // передаем вызов "обернутому" блюду
    }

}
