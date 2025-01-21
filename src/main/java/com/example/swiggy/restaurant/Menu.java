package com.example.swiggy.restaurant;

import com.example.swiggy.food.Dish;
import com.example.swiggy.food.IFood;

import java.util.Vector;

public class Menu {
    private Vector<IFood> dishes;

    public Menu() {
        dishes = new Vector<>();
    }

    public void addDish(IFood dish) {
        dishes.add(dish);
    }

    public Vector<IFood> getDishes() {
        return dishes;
    }
}
