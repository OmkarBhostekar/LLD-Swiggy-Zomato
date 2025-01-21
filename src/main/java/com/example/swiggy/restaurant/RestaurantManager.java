package com.example.swiggy.restaurant;

import java.util.HashMap;
import java.util.Map;

public class RestaurantManager {
    private static RestaurantManager instance = null;
    private static final Object lock = new Object();
    private final Map<String, Restaurant> restaurants;

    private RestaurantManager() {
        restaurants = new HashMap<>();
    }

    public static RestaurantManager getInstance() {
        synchronized (lock) {
            if (instance == null) {
                instance = new RestaurantManager();
            }
        }
        return instance;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getName(), restaurant);
    }

    public Restaurant getRestaurant(String name) {
        return restaurants.get(name);
    }

    public void removeRestaurant(String name) {
        restaurants.remove(name);
    }

    public void listRestaurants() {
        for (Map.Entry<String, Restaurant> entry : restaurants.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
