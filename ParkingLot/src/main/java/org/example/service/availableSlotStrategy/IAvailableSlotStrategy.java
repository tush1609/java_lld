package org.example.service.availableSlotStrategy;

import org.example.model.Floor;
import org.example.enums.VehicleType;

import java.util.List;
import java.util.Map;

public interface IAvailableSlotStrategy {
    Map<Integer, Integer> getAvailableSlot(List<Floor> floors, VehicleType vehicleType);
}
