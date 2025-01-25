package com.example.swiggy.payment;

public class Payment {
    final String id;
    final double amount;
    final PaymentMethod paymentMethod;
    PaymentStatus status;

    public Payment(String id, double amount, PaymentMethod paymentMethod) {
        this.id = id;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = PaymentStatus.PENDING;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void updateStatus(PaymentStatus status) {
        this.status = status;
    }
}
