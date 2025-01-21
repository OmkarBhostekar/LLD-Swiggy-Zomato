package com.example.swiggy.order;


import com.example.swiggy.food.FoodManager;
import com.example.swiggy.restaurant.Restaurant;
import com.example.swiggy.restaurant.RestaurantManager;

import java.util.HashMap;

public class OrderManager {
    private static OrderManager instance = null;
    private static final Object lock = new Object();
    private final HashMap<String, Order> orders;

    private OrderManager() {
        orders = new HashMap<>();
    }

    public static OrderManager getInstance() {
        synchronized (lock) {
            if (instance == null) {
                instance = new OrderManager();
            }
        }
        return instance;
    }

    public void placeOrder(Order order) {
        FoodManager foodManager = FoodManager.getInstance();
        foodManager.prepareFood(order.getRestaurant(), order.getDishes());
        // todo - manage delivery partner
        // todo - add user for notifications
    }

    public Order getOrder(String id) {
        return orders.get(id);
    }

}
