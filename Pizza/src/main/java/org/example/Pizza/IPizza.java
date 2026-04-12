package org.example.Pizza;

import org.example.Toppings.ITopping;

import java.util.ArrayList;
import java.util.List;

public abstract class IPizza {
    final ITopping topping;
    final float basePrice = 100;

    protected IPizza(ITopping topping) {
        this.topping = topping;
    }

    protected float costOfPizza() {
        return this.basePrice + this.topping.cost();
    }

    protected List<String> getIngredients() {
        return this.topping.getIngredients();
    }

    abstract void cook();
}
