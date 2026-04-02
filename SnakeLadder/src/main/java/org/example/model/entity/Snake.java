package org.example.model.entity;

public class Snake extends Entity {

    public Snake(int start, int end) {
        super(start, end);
        if (start <= end) {
            System.out.println("ERR: INVALID_LADDER");
        }
    }

    @Override
    void display() {
        System.out.println("SNAKE -> " + this.start + " " + this.end);
    }

    @Override
    String name() {
        return "SNAKE";
    }
}
