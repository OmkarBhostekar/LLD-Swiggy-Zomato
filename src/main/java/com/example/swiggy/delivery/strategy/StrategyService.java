package com.example.swiggy.delivery.strategy;

import com.example.swiggy.delivery.DeliveryInfo;

public class StrategyService {
    private static StrategyService instance = null;
    private static final Object lock = new Object();

    private StrategyService() {
    }

    public IDeliveryMatchingStrategy getMatchingStrategy() {
        return new LocationBasedMatchingStrategy();
    }

    public IDeliveryChargeStrategy getChargeStrategy() {
        return new DistanceBasedChargeStrategy();
    }

    public static StrategyService getInstance() {
        synchronized (lock) {
            if (instance == null) {
                instance = new StrategyService();
            }
        }
        return instance;
    }
}