package org.example.Pizza;

import org.example.Toppings.ITopping;

import java.util.List;

public class Margerrita extends IPizza {
    public Margerrita(ITopping topping) {
        super(topping);
    }

    @Override
    public void cook() {
        List<String> ingredients = this.getIngredients();
        System.out.println("Cooking started with ingredients " + ingredients + " cost -> " + this.costOfPizza());
    }
}
