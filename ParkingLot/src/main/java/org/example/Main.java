package org.example;

import org.example.enums.VehicleType;

public class Main {
    public static void main(String[] args) {
        String pId = "PR1234";
        Manager manager = new Manager();
        manager.createParkingLot(pId, 4, 4);

        String ticketId = manager.parkVehicle(pId, VehicleType.BIKE, "MH01VK1234");
        System.out.println("TICKER CREATED " + ticketId);

        manager.display(pId);
//        manager.display(pId, VehicleType.BIKE);
    }
}
