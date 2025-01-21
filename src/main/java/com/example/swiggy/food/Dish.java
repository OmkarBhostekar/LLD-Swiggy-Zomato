package com.example.swiggy.food;

public class Dish extends IFood {

    private double rating;

    public Dish(String name, double price) {
        super(name, price);
        rating = 0;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

}
