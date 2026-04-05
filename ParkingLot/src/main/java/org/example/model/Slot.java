package org.example.model;

import org.example.enums.VehicleType;

import java.util.concurrent.locks.ReentrantLock;

public class Slot {
    String id;
    VehicleType vehicleType;
    boolean isAvailable;
    ReentrantLock lock;

    public Slot(String id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.isAvailable = true;
        this.lock = new ReentrantLock();
    }

    public boolean parkSlot() {
        boolean success = false;

        this.lock.lock();
        try {
            if (this.isAvailable) {
                this.isAvailable = false;
                success = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.lock.unlock();
        }

        return success;
    }

    public void unParkSlot() {
        this.isAvailable = true;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public String toString() {
        return "SLOT: " + this.id + " " + this.vehicleType.toString() + " " + this.isAvailable;
    }
}
