package com.apps.quantitymeasurement;


public class QuantityMeasurementApp {

	//Generic method to demonstrateLengthEquality
	public static boolean  demonstarteLengthEquality(Length l1, Length l2) {
		boolean result =  l1.equals(l2) ;
		System.out.println("Input : Quanityt1 : " +l1  +" Quanity2 : " +l2);
		System.out.println("Output : Are they equal? : " +result) ;
		return result ;
	}
	
	//Demonstrate Feet equality (UC1 compatibility)
	
	public static void demonstrateFeetEquality() {
		Length f1 = new Length(1.0, Length.LengthUnit.FEET) ;
		Length f2 = new Length(1.0, Length.LengthUnit.FEET) ;
		System.out.println("Input  : 1.0 ft and 1.0 ft") ;
		System.out.println("Output : Are they equal? : " +f1.equals(f2)) ;
	}
	
	// Demonstrate Inches equality (UC2 compatibility)
	
	public static void demonstrateInchesEquality() {
		Length inch1 =  new Length(1.0, Length.LengthUnit.INCHES) ;
		Length inch2 = new Length(1.0, Length.LengthUnit.INCHES) ;
		System.out.println("Input : 1.0 inch and 1.0 inch") ;
		System.out.println("Output : Are they equals ? : " +inch1.equals(inch2)) ;
	}
	
	// Demonstrate Feet ↔ Inches comparison (UC3)
	public static void demonstrateFeetInchesComparison() {
		Length feet = new Length(1.0, Length.LengthUnit.FEET) ;
		Length inches = new Length(12.0, Length.LengthUnit.INCHES) ;
		System.out.println("Input : 1.0 ft and 12.0 inches") ;
		System.out.println("Output : Are they equal? : " +feet.equals(inches)) ;
	}
	
	public static void main(String args []) {
		demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
	}
}