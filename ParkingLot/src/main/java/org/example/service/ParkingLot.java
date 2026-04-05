package org.example.service;

import org.example.service.availableSlotStrategy.IAvailableSlotStrategy;
import org.example.service.availableSlotStrategy.SimpleAvailableSlot;
import org.example.service.createParkingSlotStrategy.ICreateParkingSlotStrategy;
import org.example.service.createParkingSlotStrategy.SimpleCreation;
import org.example.enums.VehicleType;
import org.example.model.Floor;

import java.util.*;

public class ParkingLot {
    String id;
    List<Floor> floors;
    IAvailableSlotStrategy availableSlotStrategy;
    ICreateParkingSlotStrategy createParkingSlotStrategy;

    public ParkingLot() {
        this.floors = new ArrayList<>();
        this.availableSlotStrategy = new SimpleAvailableSlot();
        this.createParkingSlotStrategy = new SimpleCreation();
    }

    public Map<Integer, Integer> getAvailableSlot(VehicleType vehicleType) {
        return this.availableSlotStrategy.getAvailableSlot(this.floors, vehicleType);
    }

    public void createParkingSlot(String parkingLotId, int floors, int slots) {
        this.id = parkingLotId;
        this.floors = this.createParkingSlotStrategy.create(floors, slots);
    }

    public boolean parkSlot(int floorIndex, int slotIndex) {
        if (floorIndex >= this.floors.size()) return false;

        Floor floor = this.floors.get(floorIndex);
        return floor.parkSlot(slotIndex);
    }

    public void unParkSlot(int floorIndex, int slotIndex) {
        if (floorIndex >= this.floors.size()) return;

        Floor floor = this.floors.get(floorIndex);
        floor.unParkSlot(slotIndex);
    }

    public String getId() {
        return this.id;
    }

    public void display() {
        System.out.println("PARKING LOT -> " + this.id);
        this.floors.forEach(Floor::display);
    }

    public void display(VehicleType vehicle) {
        System.out.println("PARKING LOT -> " + this.id);
        this.floors.forEach(f -> f.display(vehicle));
    }
}
