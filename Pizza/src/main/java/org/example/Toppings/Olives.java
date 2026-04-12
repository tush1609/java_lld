package org.example.Toppings;

import java.util.List;

public class Olives implements ITopping {
    ITopping topping;
    int quantity;

    public Olives(ITopping topping, int quantity) {
        this.topping = topping;
        this.quantity = quantity;
    }

    @Override
    public float cost() {
        return this.topping.cost() + (10*this.quantity);
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = this.topping.getIngredients();
        ingredients.add("Olives");

        return ingredients;
    }
}
