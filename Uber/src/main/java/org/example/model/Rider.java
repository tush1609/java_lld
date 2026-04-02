package org.example.model;

public class Rider {
    String id;
    String name;
    Location srcLocation;

    public Rider(String id, String name, double lat, double lng) {
        this.id = id;
        this.name = name;
        this.srcLocation = new Location(lat, lng);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getSrcLocation() {
        return srcLocation;
    }

    public void setSrcLocation(Location location) {
        this.srcLocation = location;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name;
    }
}
