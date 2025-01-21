package com.example.swiggy.delivery.strategy;

import com.example.swiggy.delivery.DeliveryInfo;
import com.example.swiggy.delivery.DeliveryPartner;

import java.util.Vector;

public class LocationBasedMatchingStrategy extends IDeliveryMatchingStrategy {
    public DeliveryPartner matchPartner(DeliveryInfo deliveryInfo, Vector<DeliveryPartner> partners) {
        // Implement the logic to match the delivery partner based on the location & online status
        // currently returning the first partner
        return partners.get(0);
    }
}
