package com.apps.quantitymeasurement.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "user-service",
        fallback = UserServiceClientFallback.class
)
public interface UserServiceClient {

    @PostMapping("/api/users/{userId}/history")
    void saveHistory(
            @PathVariable Long userId,
            @RequestBody String data
    );
}