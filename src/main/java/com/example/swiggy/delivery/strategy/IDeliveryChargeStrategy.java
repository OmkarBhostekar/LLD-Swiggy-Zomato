package com.example.swiggy.delivery.strategy;

import com.example.swiggy.delivery.DeliveryInfo;

abstract public class IDeliveryChargeStrategy {
    abstract public double calculateDeliveryCharge(DeliveryInfo deliveryInfo);
}
