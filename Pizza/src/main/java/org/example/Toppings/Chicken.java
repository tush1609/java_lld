package org.example.Toppings;

import java.util.List;

public class Chicken implements ITopping {
    ITopping topping;
    int quantity;

    public Chicken(ITopping topping, int quantity) {
        this.topping = topping;
        this.quantity = quantity;
    }

    @Override
    public float cost() {
        return this.topping.cost() + (100*this.quantity);
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = this.topping.getIngredients();
        ingredients.add("Chicken");

        return ingredients;
    }
}
