package org.example.Toppings;

import java.util.List;

public class Paneer implements ITopping {
    ITopping topping;
    int quantity;

    public Paneer(ITopping topping, int quantity) {
        this.topping = topping;
        this.quantity = quantity;
    }

    @Override
    public float cost() {
        return this.topping.cost() + (70 * this.quantity);
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = this.topping.getIngredients();
        ingredients.add("Paneer");

        return ingredients;
    }
}
