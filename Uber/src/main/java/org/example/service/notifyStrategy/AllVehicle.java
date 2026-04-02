package org.example.service.notifyStrategy;

import org.example.model.Driver;
import org.example.model.vehicle.Vehicle;

import java.util.List;

public class AllVehicle implements IDriverNotifyStrategy {
    List<Vehicle> vehicles;

    public AllVehicle(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public void notifyDriver() {
        System.out.println("NOTIFY_ALL_VEHICLE");
        this.vehicles.forEach(vehicle -> {
            Driver driver = vehicle.getDriver();
            if (driver != null) {
                System.out.println("Driver " + driver.getName() + " notified");
            }
        });
        System.out.println();
    }
}
