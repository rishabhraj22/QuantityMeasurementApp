package com.apps.quantitymeasurement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class UnitController {

    @GetMapping("/units")
    public List<String> getUnits(@RequestParam String type) {

        switch (type) {
            case "Length":
                return List.of("m", "cm", "km");

            case "Weight":
                return List.of("kg", "g", "mg");

            case "Temperature":
                return List.of("c", "f", "k");

            case "Volume":
                return List.of("l", "ml");

            default:
                throw new RuntimeException("Invalid type");
        }
    }
}