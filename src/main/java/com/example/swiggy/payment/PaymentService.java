package com.example.swiggy.payment;

import com.example.swiggy.notification.NotificationService;
import com.example.swiggy.order.Order;
import com.example.swiggy.order.OrderService;

import java.util.HashMap;

public class PaymentService {
    private static PaymentService instance = null;
    private static final Object lock = new Object();
    private HashMap<String, Payment> payments;

    private PaymentService() {
        payments = new HashMap<>();
    }

    public static PaymentService getInstance() {
        synchronized (lock) {
            if (instance == null) {
                instance = new PaymentService();
            }
        }
        return instance;
    }

    public Payment createPayment(String orderId, double amount, PaymentMethod paymentMethod, String discountCode) {
        // some payment logic based on payment method
        Payment payment = new Payment("paymentId1", amount, paymentMethod);
        payments.put(orderId, payment);
        return payment;
    }

    public void processPayment(String orderId) {
        Payment payment = payments.get(orderId);
        if (payment == null) {
            return;
        }
        // payment processing logic
        OrderService orderService = OrderService.getInstance();
        Order order = orderService.getOrder(orderId);
        order.updatePaymentStatus(PaymentStatus.SUCCESS);

        NotificationService notificationService = NotificationService.getInstance();
        notificationService.notify(order.getUser().getId(), "Payment successful for order: " + order.getId());
        notificationService.notify(order.getRestaurant().getId(), "Payment successful for order: " + order.getId());
    }
}
