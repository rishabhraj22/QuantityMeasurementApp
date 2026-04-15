package com.apps.quantitymeasurement.client;

import org.springframework.stereotype.Component;

@Component
public class UserServiceClientFallback implements UserServiceClient {

    @Override
    public void saveHistory(Long userId, String data) {

        System.out.println("🔥 FALLBACK TRIGGERED: user-service is DOWN!");
        System.out.println("History NOT saved, but conversion still successful");
    }
}