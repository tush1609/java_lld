package org.example.service.createParkingSlotStrategy;

import org.example.model.Floor;
import org.example.model.Slot;
import org.example.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class SimpleCreation implements ICreateParkingSlotStrategy {
    @Override
    public List<Floor> create(int floors, int slotPerFloor) {
        List<Floor> floorList = new ArrayList<>();

        for (int f = 0; f < floors; f++) {
            Floor floor = new Floor();
            for (int i = 0; i < Math.min(1, slotPerFloor); i++) {
                Slot slot = new Slot(i + "", VehicleType.TRUCK);
                floor.addSlot(slot);
            }

            for (int i = 1; i < Math.min(3, slotPerFloor); i++) {
                Slot slot = new Slot(i + "", VehicleType.BIKE);
                floor.addSlot(slot);
            }

            for (int i = 3; i < slotPerFloor; i++) {
                Slot slot = new Slot(i + "", VehicleType.CAR);
                floor.addSlot(slot);
            }

            floorList.add(floor);
        }

        return floorList;
    }
}
