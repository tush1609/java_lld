package org.example;

import org.example.enums.VehicleType;
import org.example.model.Ticket;
import org.example.service.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    Map<String, Ticket> ticketMap;
    Map<String, ParkingLot> parkingLotMap;

    Manager() {
        this.ticketMap = new HashMap<>();
        this.parkingLotMap = new HashMap<>();
    }

    public void createParkingLot(String parkingLotId, int noOfFloors, int noOfSlotPerFloor) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createParkingSlot(parkingLotId, noOfFloors, noOfSlotPerFloor);
        this.parkingLotMap.put(parkingLot.getId(), parkingLot);
    }

    public String parkVehicle(String parkingLotId, VehicleType vehicleType, String regNo) {
        ParkingLot parkingLot = this.parkingLotMap.get(parkingLotId);
        Map<Integer, Integer> floorSlotMap = parkingLot.getAvailableSlot(vehicleType);
        int floorIndex = -1;
        int slotIndex = -1;
        for (Map.Entry<Integer, Integer> mp: floorSlotMap.entrySet()) {
            floorIndex = mp.getKey();
            slotIndex = mp.getValue();
            break;
        }

        if (floorIndex == -1 || slotIndex == -1) {
            return "";
        }

        boolean isSlotBook = parkingLot.parkSlot(floorIndex, slotIndex);
        if (isSlotBook) {
            String ticketId = parkingLotId + "_" + floorIndex + "_" + slotIndex;
            this.ticketMap.put(ticketId, new Ticket(ticketId, floorIndex, slotIndex, regNo));

            return ticketId;
        }

        return "";
    }

    void unParkVehicle(String parkingLotId, String ticketId) {
        Ticket ticket = this.ticketMap.get(ticketId);
        int floorIndex = ticket.getFloorIndex();
        int slotIndex = ticket.getSlotIndex();

        ParkingLot parkingLot = this.parkingLotMap.get(parkingLotId);
        parkingLot.unParkSlot(floorIndex, slotIndex);
    }

    void display(String parkingLotId) {
        ParkingLot parkingLot = this.parkingLotMap.get(parkingLotId);
        parkingLot.display();
    }

    void display(String parkingLotId, VehicleType vehicleType) {
        ParkingLot parkingLot = this.parkingLotMap.get(parkingLotId);
        parkingLot.display(vehicleType);
    }
}
