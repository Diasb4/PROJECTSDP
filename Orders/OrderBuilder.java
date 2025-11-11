package Orders;

import Factory.MealFactory;
import interfaces.IMeal;

public class OrderBuilder {
    private final MealFactory factory = new MealFactory();
    private final Order order = new Order();

    public OrderBuilder setMainDish(String dishName) {
        order.setMainDish(factory.createMeal(dishName));
        return this;
    }

    public OrderBuilder addSide(String sideName) {
        order.addSide(factory.createMeal(sideName));
        return this;
    }

    public OrderBuilder setDrink(String drinkName) {
        order.setDrink(factory.createMeal(drinkName));
        return this;
    }

    public OrderBuilder setDessert(String dessertName) {
        order.setDessert(factory.createMeal(dessertName));
        return this;
    }

    public Order build() {
        return order;
    }
}
