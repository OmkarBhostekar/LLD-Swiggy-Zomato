package com.example.swiggy.notification;


import javafx.util.Pair;

import java.util.HashMap;
import java.util.Vector;

public class NotificationService {
    private static NotificationService instance = null;
    private static final Object lock = new Object();

    // orderId -> (userId, channel)
    private final HashMap<String, Vector<Pair<String, INotificationChannel>>> observers;

    private NotificationService() {
        observers = new HashMap<>();
    }

    public void addNotificationObserver(String orderId, String userId, INotificationChannel channel) {
        if (!observers.containsKey(orderId)) {
            observers.put(orderId, new Vector<>());
        }
        observers.get(orderId).add(new Pair<>(userId, channel));
    }

    public void removeNotificationObserver(String orderId, String userId) {
        if (observers.containsKey(orderId)) {
            Vector<Pair<String, INotificationChannel>> users = observers.get(orderId);
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getKey().equals(userId)) {
                    users.remove(i);
                    break;
                }
            }
        }
    }

    public void notify(String orderId, String message) {
        if (observers.containsKey(orderId)) {
            Vector<Pair<String, INotificationChannel>> users = observers.get(orderId);
            for (Pair<String, INotificationChannel> user : users) {
                user.getValue().sendNotification(user.getKey(), message);
            }
        }
        System.out.println("\n");
    }

    public static NotificationService getInstance() {
        synchronized (lock) {
            if (instance == null) {
                instance = new NotificationService();
            }
        }
        return instance;
    }
}
