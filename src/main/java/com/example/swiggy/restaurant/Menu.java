package com.example.swiggy.restaurant;

import com.example.swiggy.food.Dish;

import java.util.Vector;

public class Menu {
    private Vector<Dish> dishes;

    public Menu() {
        dishes = new Vector<>();
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public Vector<Dish> getDishes() {
        return dishes;
    }
}
