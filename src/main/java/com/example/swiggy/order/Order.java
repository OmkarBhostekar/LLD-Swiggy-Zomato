package com.example.swiggy.order;

import com.example.swiggy.common.User;
import com.example.swiggy.food.IFood;
import com.example.swiggy.payment.Payment;
import com.example.swiggy.payment.PaymentMethod;
import com.example.swiggy.payment.PaymentService;
import com.example.swiggy.payment.PaymentStatus;
import com.example.swiggy.restaurant.Restaurant;

import java.util.HashMap;
import java.util.Objects;

public class Order {
    private final String id;
    private final User user;
    private final Restaurant restaurant;
    private HashMap<IFood, Integer> dishes = new HashMap<>();
    private PaymentStatus paymentStatus;
    private String paymentId;
    private String discountCode;
    private OrderStatus status;


    public Order(
            String id,
            User user,
            Restaurant restaurant,
            HashMap<IFood, Integer> dishes,
            PaymentMethod paymentMethod,
            String discountCode
    ) {
        Payment payment = PaymentService.getInstance().createPayment(id, getTotalPrice(), paymentMethod, discountCode);
        this.id = id;
        this.user = user;
        this.restaurant = restaurant;
        this.dishes = dishes;
        this.paymentStatus = PaymentStatus.PENDING;
        this.paymentId = payment.getId();
    }

    public String getId() {
        return id;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public HashMap<IFood, Integer> getDishes() {
        return dishes;
    }

    public void updateOrderStatus(OrderStatus status) {
        this.status = status;
    }

    public void updatePaymentStatus(PaymentStatus status) {
        this.paymentStatus = status;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (IFood dish : Objects.requireNonNull(dishes).keySet()) {
            totalPrice += (dish.getPrice() * dishes.get(dish));
        }
        return totalPrice;
    }

}
