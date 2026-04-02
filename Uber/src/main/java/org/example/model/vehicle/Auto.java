package org.example.model.vehicle;

import org.example.enums.VehicleTypes;

class Auto extends Vehicle {

    public Auto(String id, double latitude, double longitude) {
        super(id, latitude, longitude);
    }

    @Override
    public float getBaseFare() {
        return 60;
    }

    @Override
    public VehicleTypes getVehicleType() {
        return VehicleTypes.AUTO;
    }
}
