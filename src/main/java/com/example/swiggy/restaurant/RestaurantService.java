package com.example.swiggy.restaurant;

import java.util.HashMap;
import java.util.Map;

public class RestaurantService {
    private static RestaurantService instance = null;
    private static final Object lock = new Object();
    private final Map<String, Restaurant> restaurants;

    private RestaurantService() {
        restaurants = new HashMap<>();
    }

    public static RestaurantService getInstance() {
        synchronized (lock) {
            if (instance == null) {
                instance = new RestaurantService();
            }
        }
        return instance;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getId(), restaurant);
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
