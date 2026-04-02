package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String id;
    String name;
    int position;
    List<Integer> moveHistory;

    public Player(String id, String name, int position) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.moveHistory = new ArrayList<>();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
        this.moveHistory.add(position);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getMoveHistory() {
        return this.moveHistory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.position;
    }
}
