package Visitor;

import Meals.Desserts.Gelato;
import Meals.Desserts.Tiramisu;
import Meals.Dish.Lasagna;
import Meals.Dish.Pizza_Margherita;
import Meals.Dish.Pizza_Pepperoni;
import Meals.Drinks.Coke;
import Meals.Drinks.Lemonade;
import Meals.Drinks.Water;

public interface MealVisitor {
    void visit(Gelato gelato);
    void visit(Tiramisu tiramisu);
    void visit(Lasagna lasagna);
    void visit(Pizza_Margherita pizza_margherita);
    void visit(Pizza_Pepperoni pizza_pepperoni);
    void visit(Coke coke);
    void visit(Water water);
    void visit(Lemonade lemonade);
}
