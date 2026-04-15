package com.apps.quantitymeasurement.core;

public enum LengthUnit implements IMeasurable {

    KM(1000.0),
    METER(1.0),
    CM(0.01),

    FEET(0.3048),
    INCHES(0.0254),
    YARDS(0.9144), CENTIMETERS;

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    LengthUnit() {
		this.conversionFactor = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }

    @Override
    public String getUnitName() {
        return this.name();
    }
}