package com.apps.quantitymeasurement.model;

import com.apps.quantitymeasurement.*;
import com.apps.quantitymeasurement.core.IMeasurable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuantityModel<U extends IMeasurable> {

    private double value;
    private U unit;
    
    public QuantityModel() {}
    
	public QuantityModel(double value, U unit) {
		super();
		this.value = value;
		this.unit = unit;
	}
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public U getUnit() {
		return unit;
	}
	public void setUnit(U unit) {
		this.unit = unit;
	}
    
    

}