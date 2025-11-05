package Factory;

import Meals.*;
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
    }

    public IMeal createDish(String type) {
        // нормализуем строку: убираем лишние пробелы, знаки и приводим к нижнему
        // регистру
        String normalized = type.trim().replaceAll("[^a-zA-Z]", "").toLowerCase();
        Supplier<IMeal> supplier = mealMap.get(normalized);
        if (supplier != null) {
            return supplier.get();
        }
        throw new IllegalArgumentException("Неизвестное блюдо: " + type);
    }
}
