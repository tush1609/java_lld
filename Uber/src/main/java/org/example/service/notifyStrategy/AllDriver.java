package org.example.service.notifyStrategy;

import org.example.enums.VehicleTypes;
import org.example.model.Driver;
import java.util.ArrayList;
import java.util.List;

public class AllDriver implements IDriverNotifyStrategy {
    List<Driver> drivers;

    public AllDriver(List<Driver> drivers) {
        this.drivers = drivers;
    }

    @Override
    public void notifyDriver() {
        System.out.println("NOTIFY_ALL_DRIVER");
        this.drivers.forEach(driver -> {
            System.out.println("Driver " + driver.getName() + " notified");
        });
        System.out.println();
    }
}
