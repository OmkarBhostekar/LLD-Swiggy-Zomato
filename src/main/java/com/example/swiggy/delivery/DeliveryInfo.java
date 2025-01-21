package com.example.swiggy.delivery;

import com.example.swiggy.common.Location;

public class DeliveryInfo {
    final String orderId;
    final Location restaurantLocation;
    final Location customerLocation;

    public DeliveryInfo(String orderId, Location restaurantLocation, Location customerLocation) {
        this.orderId = orderId;
        this.restaurantLocation = restaurantLocation;
        this.customerLocation = customerLocation;
    }

    public String getOrderId() {
        return orderId;
    }

    public Location getRestaurantLocation() {
        return restaurantLocation;
    }

    public Location getCustomerLocation() {
        return customerLocation;
    }
}
