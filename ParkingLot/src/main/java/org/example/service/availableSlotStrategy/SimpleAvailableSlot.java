package org.example.service.availableSlotStrategy;

import org.example.model.Floor;
import org.example.model.Slot;
import org.example.enums.VehicleType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAvailableSlot implements IAvailableSlotStrategy {
    @Override
    public Map<Integer, Integer> getAvailableSlot(List<Floor> floors, VehicleType vehicleType) {
        Map<Integer, Integer> availableSlot = new HashMap<>();
        for (int i = 0; i < floors.size(); i++) {
            Floor floor = floors.get(i);
            for (int j = 0; j < floor.getSlots().size(); j++) {
                Slot slot = floor.getSlots().get(j);
                if (vehicleType.equals(slot.getVehicleType())) {
                    availableSlot.put(i, j);
                    break;
                }
            }
            if (availableSlot != null) break;
        }

        return availableSlot;
    }
}
