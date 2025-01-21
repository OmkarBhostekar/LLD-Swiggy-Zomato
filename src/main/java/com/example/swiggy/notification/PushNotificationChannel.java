package com.example.swiggy.notification;

public class PushNotificationChannel extends INotificationChannel {
    public void sendNotification(String userId, String message) {
        System.out.println("Push Notification sent to " + userId + " with message: " + message);
    }
}
