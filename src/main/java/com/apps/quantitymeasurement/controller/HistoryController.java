package com.apps.quantitymeasurement.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class HistoryController {

    @PostMapping("/{userId}/history")
    public String saveHistory(@PathVariable Long userId,
                             @RequestBody String data) {

        System.out.println("History saved: " + data);
        return "Saved";
    }
}