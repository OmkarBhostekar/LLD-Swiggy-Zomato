package com.example.swiggy.delivery;

import com.example.swiggy.common.IPartner;
import com.example.swiggy.notification.NotificationService;

public class DeliveryPartner extends IPartner {

    final String id;

    public DeliveryPartner(String id, String mName) {
        super(mName);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void deliverOrder(String orderId, DeliveryInfo deliveryInfo) {
        NotificationService notificationService = NotificationService.getInstance();
        try {
            notificationService.notify(orderId, name + "is on the way to pickup the order from "
                    + deliveryInfo.getRestaurantLocation().getLatitude() + ","  + deliveryInfo.getRestaurantLocation().getLongitude());
            Thread.sleep(2000);

            notificationService.notify(orderId, name + " has picked up the order and is on the way to deliver");
            Thread.sleep(2000);

            notificationService.notify(orderId, name + " has reached at the location "
                    + deliveryInfo.getCustomerLocation().getLatitude() + "," + deliveryInfo.getCustomerLocation().getLongitude());
            Thread.sleep(2000);

            notificationService.notify(orderId, name + " has delivered the order, Enjoy your meal!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
