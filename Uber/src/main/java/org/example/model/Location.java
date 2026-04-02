package org.example.model;

public class Location {
    double latitude;
    double longitude;

    public Location(double lat, double lng) {
        this.latitude = lat;
        this.longitude = lng;
    }

    double getDistance(double lat, double lng) {
        return Math.sqrt((lat * lat) + (lng * lng));
    }

    @Override
    public String toString() {
        return this.latitude + "/" + this.longitude;
    }
}
