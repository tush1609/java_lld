package org.example.model.entity;

public class Ladder extends Entity {

    public Ladder(int start, int end) {
        super(start, end);
        if (start >= end) {
            System.out.println("ERR: INVALID_LADDER");
        }
    }

    @Override
    void display() {
        System.out.println("LADDER-> " + this.start + " " + this.end);
    }

    @Override
    String name() {
        return "LADDER";
    }
}
