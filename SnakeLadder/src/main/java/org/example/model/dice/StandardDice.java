package org.example.model.dice;

public class StandardDice implements IDice {
    int faces;

    public StandardDice(int faces) {
        this.faces = faces;
    }

    @Override
    public int getMaxNum() {
        return this.faces;
    }

    @Override
    public int roll() {
        double v = (Math.random() * this.faces) + 1;
        System.out.println("DICE -> " + (int) v);
        return (int) v;
    }
}
