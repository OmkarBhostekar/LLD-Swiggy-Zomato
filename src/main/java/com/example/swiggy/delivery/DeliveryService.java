package com.example.swiggy.delivery;

import com.example.swiggy.delivery.strategy.IDeliveryMatchingStrategy;
import com.example.swiggy.delivery.strategy.StrategyService;
import com.example.swiggy.notification.NotificationService;
import com.example.swiggy.notification.PushNotificationChannel;

import java.util.Vector;

public class DeliveryService {
    private static DeliveryService instance = null;
    private static final Object lock = new Object();

    public void manageDelivery(String orderId, DeliveryInfo deliveryInfo) {
        StrategyService strategyService = StrategyService.getInstance();
        IDeliveryMatchingStrategy matchingStrategy = strategyService.getMatchingStrategy();

        DeliveryPartnerService deliveryPartnerService = DeliveryPartnerService.getInstance();
        Vector<DeliveryPartner> deliveryPartners = deliveryPartnerService.getOnlineDeliveryPartners();
        DeliveryPartner deliveryPartner = matchingStrategy.matchPartner(deliveryInfo, deliveryPartners);


        NotificationService notificationService = NotificationService.getInstance();
        notificationService.addNotificationObserver(orderId, deliveryPartner.getId(), new PushNotificationChannel());


        deliveryPartner.deliverOrder(orderId, deliveryInfo);
    }

    public static DeliveryService getInstance() {
        synchronized (lock) {
            if (instance == null) {
                instance = new DeliveryService();
            }
        }
        return instance;
    }
}
