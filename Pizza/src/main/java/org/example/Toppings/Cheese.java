package org.example.Toppings;

import java.util.List;

public class Cheese implements ITopping {
    ITopping topping;
    int quantity;

    public Cheese(ITopping topping, int quantity) {
        this.topping = topping;
        this.quantity = quantity;
    }

    @Override
    public float cost() {
        return this.topping.cost() + (5 * this.quantity);
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = this.topping.getIngredients();
        ingredients.add("Cheese");

        return ingredients;
    }
}
