package org.example;

import org.example.enums.DriverNotifyStrategies;
import org.example.enums.VehicleTypes;
import org.example.service.BookingService;

import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        BookingService bookingService = new BookingService();

        bookingService.registerVehicle(VehicleTypes.SEDAN, "1", 23.9, 11.1);
        bookingService.registerVehicle(VehicleTypes.SEDAN, "2", 21.9, 11.1);
        bookingService.registerVehicle(VehicleTypes.AUTO, "3", 11.9, 11.1);
        bookingService.registerVehicle(VehicleTypes.AUTO, "4", 31.9, 11.1);
        bookingService.registerVehicle(VehicleTypes.AUTO, "5", 24.9, 11.1);
        bookingService.registerVehicle(VehicleTypes.AUTO, "6", 55.9, 11.1);

        bookingService.registerDriver("1", "driver_1", "101");
        bookingService.registerDriver("2", "driver_2", "102");
        bookingService.registerDriver("3", "driver_3", "103");
        bookingService.registerDriver("4", "driver_4", "104");

        bookingService.registerRider("1", "rider_1", 11, 14);
        bookingService.registerRider("2", "rider_1", 11, 14);

        bookingService.linkDriverWithVehicle("1", "1");
        bookingService.notifyRideRequest(VehicleTypes.SEDAN, DriverNotifyStrategies.ALL_DRIVER, 10, 10);
        bookingService.bookingConfirm("1", "1", "1", LocalDateTime.now().plusHours(6), 1, 11);

        bookingService.printAll();
    }
}
