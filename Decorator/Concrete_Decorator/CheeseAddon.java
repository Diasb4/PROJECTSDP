package Decorator.Concrete_Decorator;

import Decorator.MealDecorator;
import interfaces.IMeal;
import Visitor.MealVisitor;

public class CheeseAddon extends MealDecorator {

    private String cheeseType;
    private float cheeseCost;

    public CheeseAddon(IMeal meal, String cheeseType, float cheeseCost) {
        super(meal);
        this.cheeseType = cheeseType;
        this.cheeseCost = cheeseCost;
    }

    @Override
    public String getDescription() {
        return decoratedMeal.getDescription() + " + Extra " + cheeseType;
    }

    @Override
    public float getPrice() {
        return decoratedMeal.getPrice() + cheeseCost;
    }

    @Override
    public int getCookingTime() {
        return decoratedMeal.getCookingTime(); // Если добавление сыра не увеличивает время
    }

    @Override
    public void accept(MealVisitor visitor) {
        decoratedMeal.accept(visitor); // Передаем визитеру "основное блюдо"
    }

    @Override
    public void serve() {
        decoratedMeal.serve(); // передаем вызов "обернутому" блюду
    }

}
