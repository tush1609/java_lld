package org.example.model;

public class Ticket {
    String ticketId;
    int floorIndex;
    int slotIndex;
    String regNo;

    public Ticket(String ticketId, int floorIndex, int slotIndex, String regNo) {
        this.ticketId = ticketId;
        this.floorIndex = floorIndex;
        this.slotIndex = slotIndex;
        this.regNo = regNo;
    }

    public int getSlotIndex() {
        return slotIndex;
    }

    public int getFloorIndex() {
        return floorIndex;
    }
}
