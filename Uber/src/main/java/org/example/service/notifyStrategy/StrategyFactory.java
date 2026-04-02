package org.example.service.notifyStrategy;

import org.example.enums.DriverNotifyStrategies;
import org.example.model.Driver;
import org.example.model.Location;
import org.example.model.vehicle.Vehicle;

import java.util.List;

public class StrategyFactory {
    public StrategyFactory() {}

    public IDriverNotifyStrategy getStrategy(
            DriverNotifyStrategies strategies,
            List<Driver> drivers,
            List<Vehicle> vehicles,
            double lat,
            double lng) {
        switch (strategies) {
            case ALL_DRIVER -> {
                return new AllDriver(drivers);
            }
            case ALL_VEHICLE -> {
                return new AllVehicle(vehicles);
            }
            case AVAILABLE_VEHICLE -> {
                return new AvailableVehicle(vehicles);
            }
            case DISTANCE_RANGE -> {
                return new DistanceInRange(vehicles, lat, lng);
            }
        }

        return new AllDriver(drivers);
    }
}
