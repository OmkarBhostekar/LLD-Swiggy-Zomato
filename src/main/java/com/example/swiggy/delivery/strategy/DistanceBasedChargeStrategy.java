package com.example.swiggy.delivery.strategy;

import com.example.swiggy.common.Location;
import com.example.swiggy.delivery.DeliveryInfo;

public class DistanceBasedChargeStrategy extends IDeliveryChargeStrategy {
    @Override
    public double calculateDeliveryCharge(DeliveryInfo deliveryInfo) {
        Location restaurantLocation = deliveryInfo.getRestaurantLocation();
        Location customerLocation = deliveryInfo.getCustomerLocation();
        double distanceInKms = restaurantLocation.distance(customerLocation);
        return distanceInKms * 10;
    }
}
