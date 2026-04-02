package org.example.model;

import org.example.model.vehicle.Vehicle;
import java.time.LocalDateTime;

public class Book {
    String id;
    Vehicle vehicle;
    Rider rider;
    LocalDateTime bookingTime;
    Location source;
    Location destination;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public Location getSource() {
        return source;
    }

    public void setSource(Location source) {
        this.source = source;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    float price;

    public Book(
            String id,
            Vehicle vehicle,
            Rider rider,
            LocalDateTime bookingTime,
            float price,
            Location source,
            Location destination
    ) {
        this.id = id;
        this.vehicle = vehicle;
        this.rider = rider;
        this.bookingTime = bookingTime;
        this.price = price;
        this.source = source;
        this.destination = destination;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.id + " " + this.vehicle + " " + this.rider + " " + this.bookingTime + " " + this.source + " " + this.destination;
    }
}
