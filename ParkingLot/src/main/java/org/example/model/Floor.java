package org.example.model;

import org.example.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    List<Slot> slots;

    public Floor() {
        this.slots = new ArrayList<>();
    }

    public void addSlot(Slot slot) {
        this.slots.add(slot);
    }

    public List<Slot> getSlots() {
        return this.slots;
    }

    public boolean parkSlot(int slotIndex) {
        if (slotIndex >= this.slots.size()) return false;

        Slot slot = this.slots.get(slotIndex);
        return slot.parkSlot();
    }

    public void unParkSlot(int slotIndex) {
        if (slotIndex >= this.slots.size()) return;

        Slot slot = this.slots.get(slotIndex);
        slot.unParkSlot();
    }

    public void display() {
        System.out.println("FLOOR ->");
        this.slots.forEach(System.out::println);
    }

    public void display(VehicleType vehicleType) {
        System.out.println("FLOOR -> ");
        this.slots.forEach(s -> {
            if (vehicleType.equals(s.getVehicleType())) {
                if (s.isAvailable) {
                    System.out.println(s);
                }
            }
        });
    }
}
