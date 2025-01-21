package com.example.swiggy.order;


import com.example.swiggy.food.FoodService;
import com.example.swiggy.notification.NotificationService;
import com.example.swiggy.notification.PushNotificationChannel;

import java.util.HashMap;

public class OrderService {
    private static OrderService instance = null;
    private static final Object lock = new Object();
    private final HashMap<String, Order> orders;

    private OrderService() {
        orders = new HashMap<>();
    }

    public static OrderService getInstance() {
        synchronized (lock) {
            if (instance == null) {
                instance = new OrderService();
            }
        }
        return instance;
    }

    public void placeOrder(String userId, Order order) {
        orders.put(order.getId(), order);
        FoodService foodService = FoodService.getInstance();
        foodService.prepareFood(order.getId() ,order.getRestaurant(), order.getDishes());

        // order is placed, add user for notifications for this order
        NotificationService notificationService = NotificationService.getInstance();
        notificationService.addNotificationObserver(order.getId(), userId, new PushNotificationChannel());
    }

    public Order getOrder(String id) {
        return orders.get(id);
    }

}
