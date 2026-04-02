package org.example.service.notifyStrategy;

import org.example.model.Location;
import org.example.model.vehicle.Vehicle;

import java.util.List;

public class DistanceInRange implements IDriverNotifyStrategy {
    List<Vehicle> vehicles;

    public DistanceInRange(List<Vehicle> vehicles, double lat, double lng) {
        this.vehicles = vehicles;
    }

    @Override
    public void notifyDriver() {
        System.out.println("DISTANCE_IN_RANGE");
    }
}
