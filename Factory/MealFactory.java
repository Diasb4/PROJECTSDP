package Factory;

import Meals.Drinks.*;
import Meals.Desserts.*;
import Meals.SideDish.*;
import Meals.Dish.*;
import interfaces.IMeal;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MealFactory {
    private final Map<String, Supplier<IMeal>> mealMap = new HashMap<>();

    public MealFactory() {
        mealMap.put("pizza", Pizza::new);
        mealMap.put("burger", Burger::new);
        mealMap.put("salad", Salad::new);
        mealMap.put("fries", Fries::new);
        mealMap.put("coke", Coke::new);
        mealMap.put("icecream", IceCream::new);
    }

    // MealFactory с нормализацией
    public IMeal createDish(String type) {
        String normalized = type.trim().toLowerCase().replaceAll("[^a-zA-Z]", "");
        Supplier<IMeal> supplier = mealMap.get(normalized);
        if (supplier != null) {
            return supplier.get();
        }
        throw new IllegalArgumentException("Unknown dish: " + type);
    }

}
