package com.apps.quantitymeasurement;


public class QuantityMeasurementApp {

    // Inner class to represent Feet measurement
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            // 1. Reference check
            if (this == obj) {
            	return true;
            }

            // 2. Null & type check
            if (obj == null || getClass() != obj.getClass()) {
            	return false;
            }

            // 3. Cast and compare values
            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }
    
    //------Inner class to represent Inches measurement
    public static class Inches {
    	private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            
            if (this == obj) {
            	return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
            	return false;
            }

            Inches other = (Inches) obj;
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }
    
    //method to demonstrate feet equality check
    public static void demostrateFeetEquality() {
    	
    	Feet f1 =  new Feet(1.0) ;
    	Feet f2 = new Feet(1.0) ;
    	
    	System.out.println("Are they equal ? : " +f1.equals(f2)) ;
    }
    
    //method to demonstrate inches equality check
    public static void demostrateInchesEquality() {
    	
    	Inches i1 =  new Inches(1.0) ;
    	Inches i2 = new Inches(1.0) ;
    	
    	System.out.println("Are they equal ? : " +i1.equals(i2)) ;
    }
    
    
    public static void main(String args []) {
    	demostrateFeetEquality();
    	demostrateInchesEquality();
    	
    }
    
 
}