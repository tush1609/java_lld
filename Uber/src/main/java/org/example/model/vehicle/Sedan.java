package org.example.model.vehicle;

import org.example.enums.VehicleTypes;

class Sedan extends Vehicle {

    public Sedan(String id, double latitude, double longitude) {
        super(id, latitude, longitude);
    }

    @Override
    public float getBaseFare() {
        return 100;
    }

    @Override
    public VehicleTypes getVehicleType() {
        return VehicleTypes.SEDAN;
    }
}
