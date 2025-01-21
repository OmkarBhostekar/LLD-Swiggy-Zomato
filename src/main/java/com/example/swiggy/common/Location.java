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

    public double distance(Location location) {
        final int EARTH_RADIUS = 6371; // Radius of the Earth in kilometers

        double lat1 = Math.toRadians(this.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lat2 = Math.toRadians(location.getLatitude());
        double lon2 = Math.toRadians(location.getLongitude());

        // Haversine formula
        double dlat = lat2 - lat1;
        double dlon = lon2 - lon1;

        double a = Math.sin(dlat / 2) * Math.sin(dlat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dlon / 2) * Math.sin(dlon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }
}
