package org.example.service;

import org.example.enums.DriverNotifyStrategies;
import org.example.enums.VehicleTypes;
import org.example.model.Book;
import org.example.model.Location;
import org.example.model.Rider;
import org.example.model.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingService {
    List<Book> bookings;
    RiderService riderService;
    VehicleService vehicleService;

    public BookingService() {
        this.bookings = new ArrayList<>();
        this.riderService = new RiderService();
        this.vehicleService = new VehicleService();
    }

    public void registerVehicle(VehicleTypes vehicleType, String id, double lat, double lng) {
        this.vehicleService.addVehicle(vehicleType, id, lat, lng);
    }

    public void registerDriver(String id, String name, String mobNumber) {
        this.vehicleService.addDriver(id, name, mobNumber);
    }

    public void registerRider(String id, String name, double lat, double lng) {
        this.riderService.addRider(id, name, lat, lng);
    }

    public void linkDriverWithVehicle(String driverId, String vehicleId) {
        this.vehicleService.linkDriverToVehicle(driverId, vehicleId);
    }

    public void notifyRideRequest(VehicleTypes vehicleType, DriverNotifyStrategies strategy, double lat, double lng) {
        this.vehicleService.notifyRideRequest(vehicleType, strategy, lat, lng);
    }

    public void bookingConfirm(
            String bookingId,
            String riderId,
            String vehicleId,
            LocalDateTime bookingTime,
            double destinationLat,
            double destinationLong
    ) {
        Rider rider = this.riderService.getRider(riderId);
        Vehicle vehicle = this.vehicleService.getVehicle(vehicleId);

        if (vehicle == null) {
            System.out.println("ERR: VEHICLE_NOT_FOUND");
            return;
        }

        if (rider == null) {
            System.out.println("ERR: RIDER_NOT_FOUND");
            return;
        }

        if (vehicle.getDriver() == null) {
            System.out.println("ERR: DRIVER_NOT_FOUND");
            return;
        }

        float fare = this.vehicleService.getFare(vehicle);

        this.bookings.add(new Book(
                bookingId,
                vehicle,
                rider,
                bookingTime,
                fare,
                rider.getSrcLocation(),
                new Location(destinationLat, destinationLong)
        ));

        this.vehicleService.startRide(vehicle);
    }

    public void bookingEnd(String bookingId) {
        Book book = this.bookings.stream()
                .filter(b -> bookingId.equals(b.getId()))
                .findFirst()
                .orElse(null);

        if (book == null) {
            return;
        }

        this.vehicleService.endRide(book.getVehicle());
    }

    public void printAll() {
        this.riderService.printAll();
        System.out.println("\n");

        this.vehicleService.printAll();
        System.out.println("\n");

        this.bookings.forEach(System.out::println);
        System.out.println("\n");
    }
}
