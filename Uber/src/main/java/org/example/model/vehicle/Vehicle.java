package org.example.model.vehicle;

import org.example.enums.VehicleTypes;
import org.example.model.Driver;
import org.example.model.Location;

public abstract class Vehicle {
    String id;
    String otp;
    Driver driver;
    Location location;
    boolean isOnRide;

    public Vehicle(String id, double latitude, double longitude) {
        this.id = id;
        this.driver = null;
        this.location = new Location(latitude, longitude);
        this.isOnRide = false;
    }

    abstract public float getBaseFare();

    abstract public VehicleTypes getVehicleType();

    public boolean isOnRide() {
        return isOnRide;
    }

    public void setOnRide(boolean onRide) {
        isOnRide = onRide;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return this.id + " " + this.getVehicleType() + " " + this.location + " " + this.isOnRide + " with driver: " + this.driver;
    }
}
