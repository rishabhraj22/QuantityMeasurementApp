package com.apps.quantitymeasurement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apps.quantitymeasurement.model.OperationType;
import com.apps.quantitymeasurement.model.QuantityDTO;
import com.apps.quantitymeasurement.service.IQuantityMeasurementService;

@RestController
@RequestMapping("/api/v1/quantities")
public class QuantityMeasurementController {

    @Autowired
    private IQuantityMeasurementService service;

    // Compare two quantities
    @PostMapping("/compare")
    public QuantityDTO compare(@RequestBody List<QuantityDTO> quantities) {
        return service.compare(quantities.get(0), quantities.get(1));
    }

    // Convert quantity to target unit
    @PostMapping("/convert")
    public QuantityDTO convert(@RequestBody QuantityDTO quantity,
                               @RequestParam String targetUnit) {
        return service.convert(quantity, targetUnit);
    }

    // Add two quantities
    @PostMapping("/add")
    public QuantityDTO add(@RequestBody List<QuantityDTO> quantities) {
        return service.add(quantities.get(0), quantities.get(1));
    }

    // Subtract two quantities
    @PostMapping("/subtract")
    public QuantityDTO subtract(@RequestBody List<QuantityDTO> quantities) {
        return service.subtract(quantities.get(0), quantities.get(1));
    }

    // Divide two quantities
    @PostMapping("/divide")
    public double divide(@RequestBody List<QuantityDTO> quantities) {
        return service.divide(quantities.get(0), quantities.get(1));
    }

    // Get history by operation type
    @GetMapping("/history/{operation}")
    public List<QuantityDTO> getOperationHistory(@PathVariable OperationType operation) {
        return service.getOperationHistory(operation);
    }

    // Get count of operations
    @GetMapping("/count/{operation}")
    public long getOperationCount(@PathVariable OperationType operation) {
        return service.getOperationCount(operation);
    }

    // Get error operations
    @GetMapping("/errors")
    public List<QuantityDTO> getErrorOperations() {
        return service.getErrorOperations();
    }
}