package com.example.swiggy.delivery.strategy;

import com.example.swiggy.delivery.DeliveryInfo;
import com.example.swiggy.delivery.DeliveryPartner;

import java.util.Vector;

abstract public class IDeliveryMatchingStrategy {
    abstract public DeliveryPartner matchPartner(DeliveryInfo deliveryInfo, Vector<DeliveryPartner> partners);
}
