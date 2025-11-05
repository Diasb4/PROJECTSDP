package Orders;

import Factory.MealFactory;
import interfaces.IMeal;
import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    private final MealFactory factory = new MealFactory();
    private final List<IMeal> orderItems = new ArrayList<>();

    // Добавляем блюдо по имени
    public OrderBuilder addDish(String dishName) {
        IMeal meal = factory.createDish(dishName);
        orderItems.add(meal);
        return this;
    }

    public OrderBuilder addSide(String sideName) {
        IMeal side = factory.createDish(sideName);
        orderItems.add(side);
        return this;
    }

    public OrderBuilder setDrink(String drinkName) {
        IMeal drink = factory.createDish(drinkName);
        orderItems.add(drink);
        return this;
    }

    public OrderBuilder setDessert(String dessertName) {
        IMeal dessert = factory.createDish(dessertName);
        orderItems.add(dessert);
        return this;
    }

    // Возвращает готовый заказ как List<IMeal>
    public List<IMeal> build() {
        return new ArrayList<>(orderItems); // копия списка для безопасности
    }

    // Можно добавить метод подсчета суммы прямо здесь
    public double getTotalPrice() {
        return orderItems.stream().mapToDouble(IMeal::getPrice).sum();
    }
}
