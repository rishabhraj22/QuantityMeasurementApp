package com.apps.quantitymeasurement;
import java.util.function.Function ;

public enum TemperatureUnit implements IMeasurable{

	CELSIUS(C->C, C->C) ,
	FAHRENHEIT(F -> (F - 32) * 5 / 9,        
            C -> (C * 9 / 5) + 32 ), 
	KELVIN(K-> K-273.15, C->C + 273.15) ;
	
	private final Function<Double, Double> toCelsius ;
	private final Function<Double, Double> fromCelsius;
	
	TemperatureUnit(Function<Double, Double> toCelsius, Function<Double, Double> fromCelsius) {
		this.toCelsius = toCelsius ;
		this.fromCelsius = fromCelsius;
	}
	
	 @Override
	    public double convertToBaseUnit(double value) {
	        return toCelsius.apply(value); // Base unit = Celsius
	    }

	    @Override
	    public double convertFromBaseUnit(double baseValue) {
	        return fromCelsius.apply(baseValue);
	    }

	    @Override
	    public double getConversionFactor() {
	        return 1.0; // Not meaningful for temperature (non-linear), dummy value
	    }

	    @Override
	    public String getUnitName() {
	        return name(); // CELSIUS, FAHRENHEIT, KELVIN
	    }
	
}