package com.example.swiggy.food;

public class AddOn extends IFood {
    final IFood dish;

    public AddOn(String name, double price, IFood dish) {
        super(name, price);
        this.dish = dish;
    }

    public double getPrice() {
        return price + dish.getPrice();
    }

    public String getName() {
        return dish.getName() + "with " + name;
    }
}
