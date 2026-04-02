package org.example.model;

import org.example.model.entity.Entity;

import java.util.HashMap;
import java.util.stream.Stream;

public class Board {
    int size;
    HashMap<Integer, Entity> entityMap;

    public Board(int size) {
        this.size = size;
        this.entityMap = new HashMap<>();
    }

    boolean canPlaceEntity(Entity entity) {
        if (this.entityMap.containsKey(entity.getStart())) {
            return false;
        }

        int position = entity.getStart();
        boolean isLoop = false;

        HashMap<Integer, Boolean> visited = new HashMap<>();
        visited.put(position, true);
        while(this.entityMap.containsKey(position)) {
            if (visited.get(position)) {
                System.out.println("INFINITE LOOP DETECTED");
                isLoop = true;
                break;
            }

            position = this.entityMap.get(position).getEnd();
            visited.put(position, true);
        }

        return !isLoop;
    }

    public void addEntity(Entity entity) {
        if (this.canPlaceEntity(entity)) {
            this.entityMap.put(entity.getStart(), entity);
        }
    }

    public HashMap<Integer, Entity> getEntity() {
        return this.entityMap;
    }

    public int getSize() {
        return this.size;
    }

    public void print() {
        System.out.println("PRINT BOARD");
        this.entityMap.values().forEach(System.out::println);
    }
}
