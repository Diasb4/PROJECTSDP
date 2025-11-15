package Factory;

import Meals.Drinks.*;
import Meals.Desserts.*;
import Meals.Dish.*;
import interfaces.IMeal;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MealFactory {

    private final Map<String, Supplier<IMeal>> registry = new HashMap<>();

    public MealFactory() {
        registry.put("pizzamargherita", Pizza_Margherita::new);
        registry.put("pizzapepperoni", Pizza_Pepperoni::new);
        registry.put("lasagna", Lasagna::new);
        registry.put("gelato", Gelato::new);
        registry.put("tiramisu", Tiramisu::new);
        registry.put("coke", Coke::new);
        registry.put("lemonade", Lemonade::new);
        registry.put("water", Water::new);
    }

    public IMeal createMeal(String type) {
        String normalized = type.trim().toLowerCase().replaceAll("[^a-z]", "");

        Supplier<IMeal> supplier = registry.get(normalized);

        if (supplier == null) {
            throw new IllegalArgumentException(
                    "Menu item not found: " + type + ". Please check your spelling.");
        }

        return supplier.get();
    }
}
