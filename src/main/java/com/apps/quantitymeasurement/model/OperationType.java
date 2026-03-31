package com.apps.quantitymeasurement.model;

public enum OperationType {

    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE,
    COMPARE,
    CONVERT;

    public String getDisplayValue() {
        return this.name().toLowerCase();
    }
}