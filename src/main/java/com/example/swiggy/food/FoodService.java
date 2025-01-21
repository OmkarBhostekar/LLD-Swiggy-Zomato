package com.example.swiggy.food;


import com.example.swiggy.common.User;
import com.example.swiggy.delivery.DeliveryInfo;
import com.example.swiggy.delivery.DeliveryService;
import com.example.swiggy.notification.NotificationService;
import com.example.swiggy.notification.SMSNotificationChannel;
import com.example.swiggy.order.Order;
import com.example.swiggy.order.OrderService;
import com.example.swiggy.restaurant.Restaurant;
import com.example.swiggy.restaurant.RestaurantService;

import java.util.HashMap;

public class FoodService {
    private static FoodService instance = null;
    private static final Object lock = new Object();

    public static FoodService getInstance() {
        synchronized (lock) {
            if (instance == null) {
                instance = new FoodService();
            }
        }
        return instance;
    }

    public void prepareFood(String orderId, String restaurantId, HashMap<IFood, Integer> dishes) {
        try {
            RestaurantService restaurantService = RestaurantService.getInstance();
            Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
            restaurant.prepareFood(dishes);

            // restaurant is added to receive notifications for this order
            NotificationService notificationService = NotificationService.getInstance();
            notificationService.addNotificationObserver(orderId, restaurantId, new SMSNotificationChannel());
            notificationService.notify(orderId, "Order is being prepared");

            Thread.sleep(2000);

            notificationService.notify(orderId, "Order is ready for delivery");
            OrderService orderService = OrderService.getInstance();
            Order order =  orderService.getOrder(orderId);
            User user = order.getUser();

            DeliveryService deliveryService = DeliveryService.getInstance();
            DeliveryInfo deliveryInfo = new DeliveryInfo(orderId, restaurant.getLocation(), user.getLocation());
            deliveryService.manageDelivery(orderId, deliveryInfo);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
