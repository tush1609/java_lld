package org.example.Pizza;

import org.example.Toppings.ITopping;

import java.util.List;

public class FarmHouse extends IPizza {
    public FarmHouse(ITopping topping) {
        super(topping);
    }

    @Override
    public void cook() {
        List<String> ingredients = this.getIngredients();
        System.out.println("Farm House preparation started with ingredients " + ingredients + " cost -> " + this.costOfPizza());
    }
}
