package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

	//UC1-UC-4 : Equality
	public static boolean demonstrateLengthEquality(Length l1, Length l2) {
		return l1.equals(l2) ;
	}
	
	
    public static boolean demonstrateLengthComparison(double v1, LengthUnit u1,
                                                      double v2, LengthUnit u2) {
        return demonstrateLengthEquality(new Length(v1, u1), new Length(v2, u2)) ;
    }
    
    
    //UC-5 : Conversion(Overloaded)
    public static Length demonstrateLengthConversion(Length length, LengthUnit toUnit) {
    	return length.convertTo(toUnit) ;
    }
    
    //UC6: Addition
    public static Length demonstrateLengthAddition(Length length1, Length length2) {
    	return length1.add(length2) ;
    }
    
    //UC7 : Target Addition
    public static Length demonstrateLengthAddition(Length l1, Length l2, LengthUnit targetUnit) {
    	return l1.add(l2, targetUnit) ;
    }
    public static void main(String[] args) {

		System.out.println("===== UC8 DEMO OUTPUT =====");

		System.out.println(new Length(1, LengthUnit.FEET).convertTo(LengthUnit.INCHES));
		System.out.println(new Length(1, LengthUnit.FEET).add(new Length(12, LengthUnit.INCHES), LengthUnit.FEET));

		System.out.println(new Length(36, LengthUnit.INCHES).equals(new Length(1, LengthUnit.YARDS)));

		System.out.println(new Length(1, LengthUnit.YARDS).add(new Length(3, LengthUnit.FEET), LengthUnit.YARDS));

		System.out.println(new Length(2.54, LengthUnit.CENTIMETERS).convertTo(LengthUnit.INCHES));
	}
}