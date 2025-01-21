package com.example.swiggy.food;

/***
 * We'll be using decorator pattern to add addons to the food items.
 * This is the base class for all the food items & addons.
 */
abstract public class IFood {
    protected double price;
    protected String name;

    public IFood(String mName, double mPrice) {
        this.name = mName;
        price = mPrice;
    }

    String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
