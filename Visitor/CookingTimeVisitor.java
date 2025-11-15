package Visitor;

import Meals.Desserts.Gelato;
import Meals.Desserts.Tiramisu;
import Meals.Dish.Lasagna;
import Meals.Dish.Pizza_Margherita;
import Meals.Dish.Pizza_Pepperoni;
import Meals.Drinks.Coke;
import Meals.Drinks.Lemonade;
import Meals.Drinks.Water;

public class CookingTimeVisitor implements MealVisitor{
    private int totalTime=0;

    @Override
    public void visit(Pizza_Margherita pizza_margherita) {
        totalTime+=pizza_margherita.getCookingTime();
    }

    @Override
    public void visit(Pizza_Pepperoni pizza_pepperoni) {
        totalTime+=pizza_pepperoni.getCookingTime();
    }

    @Override
    public void visit(Gelato gelato) {
        totalTime+=gelato.getCookingTime();
    }

    @Override
    public void visit(Tiramisu tiramisu) {
        totalTime+=tiramisu.getCookingTime();

    }

    @Override
    public void visit(Coke coke) {
        totalTime+=coke.getCookingTime();

    }

    @Override
    public void visit(Water water) {
        totalTime+=water.getCookingTime();
    }

    @Override
    public void visit(Lemonade lemonade) {
        totalTime+= lemonade.getCookingTime();

    }

    @Override
    public void visit(Lasagna lasagna) {
        totalTime+= lasagna.getCookingTime();

    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }
}
