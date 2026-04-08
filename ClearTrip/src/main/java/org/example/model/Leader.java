package org.example.model;

public class Leader {
    String id;
    String name;
    String mobNo;

    public Leader(String id, String name, String mobNo) {
        this.id = id;
        this.name = name;
        this.mobNo = mobNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobNo() {
        return mobNo;
    }

    public String getId() {
        return id;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }
}
