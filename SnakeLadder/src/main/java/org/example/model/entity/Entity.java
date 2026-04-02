package org.example.model.entity;

public abstract class Entity {
    int start;
    int end;

    Entity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    abstract void display();
    abstract String name();

    @Override
    public String toString() {
        return this.start + " -> " + this.end;
    }
}
