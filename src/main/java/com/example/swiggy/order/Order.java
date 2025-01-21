package com.example.swiggy.order;

import com.example.swiggy.common.User;
import com.example.swiggy.food.IFood;
import com.example.swiggy.restaurant.Restaurant;

import java.util.HashMap;

public class Order {
    private final String id;
    private final User user;
    private final Restaurant restaurant;
    private final HashMap<IFood, Integer> dishes;
    private String paymentId;
    private String discountCode;
    private OrderStatus status;


    public Order(String id, User user, Restaurant restaurant, HashMap<IFood, Integer> dishes) {
        this.id = id;
        this.user = user;
        this.restaurant = restaurant;
        this.dishes = dishes;
    }

    public String getId() {
        return id;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getUser() {
        return user.getId();
    }

    public String getRestaurant() {
        return restaurant.getName();
    }

    public HashMap<IFood, Integer> getDishes() {
        return dishes;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (IFood dish : dishes.keySet()) {
            totalPrice += (dish.getPrice() * dishes.get(dish));
        }
        return totalPrice;
    }

}
