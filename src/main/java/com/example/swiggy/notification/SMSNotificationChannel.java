package com.example.swiggy.notification;

public class SMSNotificationChannel extends INotificationChannel {
    public void sendNotification(String userId, String message) {
        System.out.println("SMS sent to " + userId + " with message: " + message);
    }
}
