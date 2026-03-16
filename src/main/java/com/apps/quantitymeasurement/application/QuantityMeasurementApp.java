package com.apps.quantitymeasurement.application;

import com.apps.quantitymeasurement.model.QuantityDTO;
import com.apps.quantitymeasurement.repository.QuantityMeasurementCacheRepository;
import com.apps.quantitymeasurement.service.QuantityMeasurementServiceImpl;
import com.apps.quantitymeasurement.service.IQuantityMeasurementService;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

    	IQuantityMeasurementService service =
                new QuantityMeasurementServiceImpl(
                        QuantityMeasurementCacheRepository.getInstance()
                );

        QuantityDTO q1 =
                new QuantityDTO(1, QuantityDTO.LengthUnit.FEET);

        QuantityDTO q2 =
                new QuantityDTO(12, QuantityDTO.LengthUnit.INCHES);

        System.out.println("Are equal: " + service.compare(q1, q2));
    }
}