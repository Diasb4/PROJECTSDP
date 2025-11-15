package interfaces;

import Visitor.MealVisitor;

public interface IMeal {
    String getDescription();

    void serve();

    float getPrice();

    int getCookingTime();

    void accept(MealVisitor visitor);
}
