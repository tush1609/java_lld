package org.example.service.notifyStrategy;

import org.example.model.Driver;
import org.example.model.vehicle.Vehicle;

import java.util.List;

public class AvailableVehicle implements IDriverNotifyStrategy {
    List<Vehicle> vehicles;

    public AvailableVehicle(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public void notifyDriver() {
        System.out.println("AVAILABLE_VEHICLE");
        this.vehicles.forEach(vehicle -> {
            Driver driver = vehicle.getDriver();
            if (!vehicle.isOnRide() && driver != null) {
                System.out.println("Driver " + driver.getName() + " notified");
            }
        });
        System.out.println();
    }
}
