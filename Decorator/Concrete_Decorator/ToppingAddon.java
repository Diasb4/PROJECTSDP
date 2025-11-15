package Decorator.Concrete_Decorator;

import Decorator.MealDecorator;
import interfaces.IMeal;
import Visitor.MealVisitor;

public class ToppingAddon extends MealDecorator {

    private String toppingName;
    private float toppingCost;

    public ToppingAddon(IMeal meal, String toppingName, float toppingCost) {
        super(meal);
        this.toppingName = toppingName;
        this.toppingCost = toppingCost;
    }

    @Override
    public String getDescription() {
        return decoratedMeal.getDescription() + " + Extra " + toppingName;
    }

    @Override
    public float getPrice() {
        return decoratedMeal.getPrice() + toppingCost;
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
