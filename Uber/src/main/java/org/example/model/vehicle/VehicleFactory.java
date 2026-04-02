package org.example.model.vehicle;

import org.example.enums.VehicleTypes;

public class VehicleFactory {
    public Vehicle getVehicle(VehicleTypes vehicleType, String id, double latitude, double longitude) {
        switch (vehicleType) {
            case SEDAN -> {
                return new Sedan(id, latitude, longitude);
            }
            case AUTO -> {
                return new Auto(id, latitude, longitude);
            }
        }

        return new Sedan(id, latitude, longitude);
    }
}
