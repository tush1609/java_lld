package org.example.service;

import org.example.enums.DriverNotifyStrategies;
import org.example.enums.VehicleTypes;
import org.example.model.Driver;
import org.example.model.vehicle.Vehicle;
import org.example.model.vehicle.VehicleFactory;
import org.example.service.notifyStrategy.IDriverNotifyStrategy;
import org.example.service.notifyStrategy.StrategyFactory;

import java.util.*;

public class VehicleService {
    Map<VehicleTypes, List<Vehicle>> vehicles;
    List<Driver> drivers;
    StrategyFactory strategyFactory;
    VehicleFactory vehicleFactory;

    public VehicleService() {
        this.vehicles = new HashMap<>();
        this.drivers = new ArrayList<>();
        this.strategyFactory = new StrategyFactory();
        this.vehicleFactory = new VehicleFactory();
    }

    Vehicle getVehicle(String vehicleId) {
        return this.vehicles.values()
                .stream()
                .flatMap(List::stream)
                .filter(v -> vehicleId.equals(v.getId()))
                .findFirst()
                .orElse(null);
    }

    Driver getDriver(String driverId) {
        return this.drivers.stream()
                .filter(d -> driverId.equals(d.getId()))
                .findFirst()
                .orElse(null);
    }

    float surgeCharge() {
        long engagedVehicles = this.vehicles.values()
                .stream()
                .flatMap(List::stream)
                .filter(Vehicle::isOnRide)
                .count();

        long totalVehicle = this.vehicles.values()
                .stream()
                .flatMap(List::stream)
                .count();

        if (totalVehicle == 0) return 0;

        long surge = (engagedVehicles/totalVehicle) * 100;

        return surge + 100;
    }

    public void addDriver(String id, String name, String mobNumber) {
        this.drivers.add(new Driver(id, name, mobNumber));
    }

    public void addVehicle(VehicleTypes vehicleType, String id, double latitude, double longitude) {
        Vehicle vehicle = this.vehicleFactory.getVehicle(vehicleType, id, latitude, longitude);
        this.vehicles.computeIfAbsent(vehicle.getVehicleType(), k -> new ArrayList<>());
        this.vehicles.get(vehicle.getVehicleType()).add(vehicle);
    }

    public void linkDriverToVehicle(String driverId, String vehicleId) {
        Driver driver = this.getDriver(driverId);
        Vehicle vehicle = this.getVehicle(vehicleId);

        if (driver != null && vehicle != null) {
            vehicle.setDriver(driver);
        }
    }

    public void notifyRideRequest(VehicleTypes vehicleType, DriverNotifyStrategies strategy, double lat, double lng) {
        List<Vehicle> allVehicles = this.vehicles.values()
                .stream()
                .flatMap(List::stream)
                .filter(v -> vehicleType.equals(v.getVehicleType()))
                .toList();

        IDriverNotifyStrategy notify = this.strategyFactory.getStrategy(strategy, this.drivers, allVehicles, lat, lng);
        notify.notifyDriver();
    }

    public void startRide(Vehicle vehicle) {
        vehicle.setOnRide(true);
    }

    public void endRide(Vehicle vehicle) {
        vehicle.setOnRide(false);
    }

    public float getFare(Vehicle vehicle) {
        return vehicle.getBaseFare() + this.surgeCharge();
    }

    public void  printAll() {
        System.out.println("ALL Vehicles");
        this.vehicles.values()
                .stream()
                .flatMap(List::stream)
                .forEach(System.out::println);

        System.out.println("\nALL Drivers");
        this.drivers.forEach(System.out::println);

        System.out.println("\n");
    }
}
