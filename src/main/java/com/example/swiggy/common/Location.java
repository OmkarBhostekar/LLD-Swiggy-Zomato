package com.example.swiggy.common;

public class Location {
    private final double latitude;
    private final double longitude;

    public Location(double mLatitude, double mLongitude) {
        latitude = mLatitude;
        longitude = mLongitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
