package org.example.model.dice;

public class BiasedDice implements IDice {
    int num;

    public BiasedDice(int num) {
        this.num = num;
    }

    @Override
    public int getMaxNum() {
        return this.num;
    }

    @Override
    public int roll() {
        System.out.println("DICE -> " + (int) this.num);
        return this.num;
    }
}
