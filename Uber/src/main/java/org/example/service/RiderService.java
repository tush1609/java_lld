package org.example.service;

import org.example.model.Rider;

import java.util.ArrayList;
import java.util.List;

public class RiderService {
    List<Rider> riders;

    public RiderService() {
        this.riders = new ArrayList<>();
    }

    public void addRider(String id, String name, double lat, double lng) {
        this.riders.add(new Rider(id, name, lat, lng));
    }

    public Rider getRider(String riderId) {
        return this.riders.stream()
                .filter(r -> riderId.equals(r.getId()))
                .findFirst()
                .orElse(null);
    }

    public void printAll() {
        System.out.println("ALL Riders");
        this.riders.forEach(System.out::println);
    }
}
