package com.example.swiggy.common;

abstract public class IPartner {
    protected double rating;
    protected String name;

    protected IPartner(String mName) {
        this.name = mName;
        rating = 0;
    }

    String getName() {
        return name;
    }
}
