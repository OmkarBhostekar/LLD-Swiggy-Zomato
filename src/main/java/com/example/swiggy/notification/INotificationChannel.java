package com.example.swiggy.notification;

abstract public class INotificationChannel {
    abstract public void sendNotification(String userId, String message);
}
