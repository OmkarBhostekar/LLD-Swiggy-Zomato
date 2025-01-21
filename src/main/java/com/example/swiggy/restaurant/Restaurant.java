package com.example.swiggy.restaurant;

import com.example.swiggy.common.Location;
import com.example.swiggy.food.IFood;

import java.util.HashMap;

public class Restaurant {
    private final String id;
    private final String name;
    private final RestaurantOwner owner;
    private final Location location;
    private Menu menu;
    private double rating;
    private boolean isOnline;

    public Restaurant(String mId, String mName, RestaurantOwner mOwner, Location mLocation) {
        id = mId;
        name = mName;
        owner = mOwner;
        location = mLocation;
        isOnline = false;
        rating = 0;
    }

    public void prepareFood(HashMap<IFood, Integer> dishes) {
        // Prepare food
        System.out.println("Preparing food - "+ name);
        dishes.forEach((dish, quantity) -> {
            System.out.println(quantity + " of " + dish.getName());
        });
        System.out.println("\n");

    }

    public Menu getMenu() {
        return menu;
    }

    public void addMenu(Menu mMenu) {
        menu = mMenu;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setRating(double mRating) {
        rating = mRating;
    }

    public void setOnline() {
        isOnline = true;
    }

    public void setOffline() {
        isOnline = false;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public double getRating() {
        return rating;
    }

    public Location getLocation() {
        return location;
    }

    public RestaurantOwner getOwner() {
        return owner;
    }
}
