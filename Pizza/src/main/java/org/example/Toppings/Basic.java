package org.example.Toppings;

import java.util.ArrayList;
import java.util.List;

public class Basic implements ITopping {
    @Override
    public float cost() {
        return 10;
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("Mayonese");

        return ingredients;
    }
}
