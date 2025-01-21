package com.example.swiggy.common;

public class User {
    private final String id;
    private final String name;
    private final Location location;

    public User(String id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }


    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getId() {
        return id;
    }
}
