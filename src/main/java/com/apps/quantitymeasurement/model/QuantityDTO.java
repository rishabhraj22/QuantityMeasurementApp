package com.apps.quantitymeasurement.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class QuantityDTO {

    @NotNull(message = "Value cannot be null")
    private Double value;

    @NotNull(message = "Unit cannot be null")
    private String unit;

    @NotNull(message = "Measurement type cannot be null")
    @Pattern(regexp = "Length|Weight|Volume|Temperature", message = "Invalid measurement type")
    private String measurementType;

    public QuantityDTO() {
    }

    public QuantityDTO(Double value, String unit, String measurementType) {
        this.value = value;
        this.unit = unit;
        this.measurementType = measurementType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(String measurementType) {
        this.measurementType = measurementType;
    }
}