package Orders;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;

import Factory.MealFactory;
import interfaces.IMeal;
import Decorator.MealDecorator;

public class OrderBuilder {
    private final MealFactory factory = new MealFactory();
    private final Order order = new Order();

    // Декораторы для каждого блюда
    private Function<IMeal, IMeal> mainDecorator;
    private List<Function<IMeal, IMeal>> sideDecorators = new ArrayList<>();
    private Function<IMeal, IMeal> drinkDecorator;
    private Function<IMeal, IMeal> dessertDecorator;

    // Устанавливаем блюда
    public OrderBuilder setMainDish(String dishName) {
        IMeal meal = factory.createMeal(dishName);
        if (mainDecorator != null)
            meal = mainDecorator.apply(meal);
        order.setMainDish(meal);
        return this;
    }

    public OrderBuilder addSide(String sideName) {
        IMeal meal = factory.createMeal(sideName);
        for (Function<IMeal, IMeal> decorator : sideDecorators) {
            meal = decorator.apply(meal);
        }
        order.addSide(meal);
        return this;
    }

    public OrderBuilder setDrink(String drinkName) {
        IMeal meal = factory.createMeal(drinkName);
        if (drinkDecorator != null)
            meal = drinkDecorator.apply(meal);
        order.setDrink(meal);
        return this;
    }

    public OrderBuilder setDessert(String dessertName) {
        IMeal meal = factory.createMeal(dessertName);
        if (dessertDecorator != null)
            meal = dessertDecorator.apply(meal);
        order.setDessert(meal);
        return this;
    }

    // Добавляем декораторы
    public void addDecoratorToMain(Function<IMeal, IMeal> decorator) {
        this.mainDecorator = decorator;
    }

    public void addDecoratorToSide(Function<IMeal, IMeal> decorator) {
        this.sideDecorators.add(decorator);
    }

    public void addDecoratorToDrink(Function<IMeal, IMeal> decorator) {
        this.drinkDecorator = decorator;
    }

    public void addDecoratorToDessert(Function<IMeal, IMeal> decorator) {
        this.dessertDecorator = decorator;
    }

    public Order build() {
        return order;
    }
}
