package com.example.swiggy.delivery;

import com.example.swiggy.delivery.strategy.IDeliveryMatchingStrategy;
import com.example.swiggy.delivery.strategy.StrategyService;

import java.util.HashMap;
import java.util.Vector;

public class DeliveryPartnerService {
    private static DeliveryPartnerService instance = null;
    private static final Object lock = new Object();
    private final HashMap<DeliveryPartner, Boolean> deliveryPartners;

    private DeliveryPartnerService() {
        deliveryPartners = new HashMap<>();
    }

    public void addDeliveryPartner(DeliveryPartner deliveryPartner) {
        deliveryPartners.put(deliveryPartner, true);
    }

    public void removeDeliveryPartner(DeliveryPartner deliveryPartner) {
        deliveryPartners.remove(deliveryPartner);
    }

    public void updateOnlineStatus(DeliveryPartner deliveryPartner, boolean isOnline) {
        deliveryPartners.put(deliveryPartner, isOnline);
    }

    public Vector<DeliveryPartner> getOnlineDeliveryPartners() {
        Vector<DeliveryPartner> onlineDeliveryPartners = new Vector<>();
        for (DeliveryPartner deliveryPartner : deliveryPartners.keySet()) {
            if (deliveryPartners.get(deliveryPartner)) {
                onlineDeliveryPartners.add(deliveryPartner);
            }
        }
        return onlineDeliveryPartners;
    }

    public static DeliveryPartnerService getInstance() {
        synchronized (lock) {
            if (instance == null) {
                instance = new DeliveryPartnerService();
            }
        }
        return instance;
    }
}