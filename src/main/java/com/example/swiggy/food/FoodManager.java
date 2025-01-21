package com.example.swiggy.food;


import com.example.swiggy.order.Order;
import com.example.swiggy.order.OrderManager;
import com.example.swiggy.restaurant.Restaurant;
import com.example.swiggy.restaurant.RestaurantManager;

import java.util.HashMap;

public class FoodManager {
    private static FoodManager instance = null;
    private static final Object lock = new Object();

    private FoodManager() {
    }

    public static FoodManager getInstance() {
        synchronized (lock) {
            if (instance == null) {
                instance = new FoodManager();
            }
        }
        return instance;
    }

    public void prepareFood(String restaurantId, HashMap<IFood, Integer> dishes) {
        RestaurantManager restaurantManager = RestaurantManager.getInstance();
        Restaurant restaurant = restaurantManager.getRestaurant(restaurantId);
        restaurant.prepareFood(dishes);

        // todo - add restaurant to notification sender
    }
}
