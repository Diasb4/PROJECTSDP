package Factory;

import Meals.Drinks.*;
import Meals.Desserts.*;
import Meals.Dish.*;
import interfaces.IMeal;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MealFactory {
    private final Map<String, Supplier<IMeal>> mealMap = new HashMap<>();

    public MealFactory() {
        // ключи без пробелов, чтобы совпадали с нормализацией
        mealMap.put("pizzamargherita", Pizza_Margherita::new);
        mealMap.put("pizzapepperoni", Pizza_Pepperoni::new);
        mealMap.put("lasagna", Lasagna::new);
        mealMap.put("gelato", Gelato::new);
        mealMap.put("tiramisu", Tiramisu::new);
        mealMap.put("coke", Coke::new);
        mealMap.put("lemonade", Lemonade::new);
        mealMap.put("water", Water::new);
    }

    public IMeal createMeal(String type) {
        String normalized = type.trim().toLowerCase().replaceAll("[^a-z]", ""); // убираем всё, кроме латиницы
        Supplier<IMeal> supplier = mealMap.get(normalized);
        if (supplier != null) {
            return supplier.get();
        }
        throw new IllegalArgumentException("Menu item not found: " + type + ". Please check your spelling.");

    }
}
