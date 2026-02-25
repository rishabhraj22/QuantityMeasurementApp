package com.apps.quantitymeasurement;

import java.util.Objects;

public class Quantity <U extends IMeasureable>{

	private final double value ;
	private final U unit ;
	
	public Quantity(double value, U unit ) {
		if(unit == null) {
			throw new IllegalArgumentException("Unit cannot be null" ) ;
		}
		if(Double.isNaN(value)) {
			throw new IllegalArgumentException("Invalid value") ;
		}
		
		this.value = value ;
		this.unit = unit ;
		
	}
	
	public double getValue() {
		return value ;
	}
	
	public U getUnit() {
		return unit ;
	}
	
	private double toBaseUnit() {
		return unit.convertToBaseUnit(value) ;
	}
	
	public Quantity<U> convertTo(U targetUnit) {
		if(targetUnit == null) {
			throw new IllegalArgumentException("Target unit cannot be null") ;
		}
		
		double baseValue = toBaseUnit() ;
		double convertedValue = targetUnit.convertFromBaseUnit(baseValue) ;
		
		return new Quantity<>(convertedValue, targetUnit) ;
	}
	
	public Quantity<U> add(Quantity<U> other) {
		
		if(other == null || unit == null) {
			throw new IllegalArgumentException("Invalid arguments") ;
		}
		
		double sumBase = this.toBaseUnit() + other.toBaseUnit() ;
		double resultValue = unit.convertFromBaseUnit(sumBase) ;
		return new Quantity<>(resultValue, unit) ;
		
	}
	
	public Quantity<U> add(Quantity<U> other, U targetUnit) {
		if(other == null || targetUnit ==null) {
			throw new IllegalArgumentException("Invalid arguments") ;
		}
		
		double sumBase = this.toBaseUnit() +other.toBaseUnit() ;
		double resultValue = targetUnit.convertFromBaseUnit(sumBase) ;
		
		return new Quantity<>(resultValue, targetUnit) ;
		
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true ;
		}
		if(obj ==  null || getClass() != obj.getClass()) {
			return false;
		}
		
		Quantity<?> other = (Quantity<?>) obj ;
		return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < 0.01 ;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Math.round(toBaseUnit() * 100.0) /100.0) ;
	}
	
	
} 