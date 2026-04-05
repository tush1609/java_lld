package org.example.service.createParkingSlotStrategy;

import org.example.model.Floor;

import java.util.List;

public interface ICreateParkingSlotStrategy {
    List<Floor> create(int floors, int slotPerFloor);
}
