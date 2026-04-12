package org.example;

import org.example.Pizza.FarmHouse;
import org.example.Pizza.Margerrita;
import org.example.Toppings.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void cookFarmHouse() {
        ITopping topping = new Basic();
        topping = new Cheese(topping, 10);
        topping = new Olives(topping, 20);
        topping = new Chicken(topping, 100);

        FarmHouse fh = new FarmHouse(topping);
        fh.cook();
    }

    static void cookMargerrita() {
        ITopping topping = new Basic();
        topping = new Cheese(topping, 10);

        Margerrita mh = new Margerrita(topping);
        mh.cook();
    }

    public static void main(String[] args) {
        Main.cookFarmHouse();
        Main.cookMargerrita();
    }
}
