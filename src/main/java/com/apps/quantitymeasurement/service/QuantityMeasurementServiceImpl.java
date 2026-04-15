package com.apps.quantitymeasurement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.quantitymeasurement.client.UserServiceClient;
import com.apps.quantitymeasurement.core.IMeasurable;
import com.apps.quantitymeasurement.core.LengthUnit;
import com.apps.quantitymeasurement.core.Quantity;
import com.apps.quantitymeasurement.core.TemperatureUnit;
import com.apps.quantitymeasurement.core.VolumeUnit;
import com.apps.quantitymeasurement.core.WeightUnit;
import com.apps.quantitymeasurement.model.OperationType;
import com.apps.quantitymeasurement.model.QuantityDTO;
import com.apps.quantitymeasurement.repository.QuantityMeasurementRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    @Autowired
    private QuantityMeasurementRepository repository;

    // 🔥 Feign Client
    @Autowired
    private UserServiceClient userServiceClient;

    private Quantity<IMeasurable> toQuantity(QuantityDTO dto) {
        IMeasurable unit = getCoreUnit(dto.getUnit());
        return new Quantity<>(dto.getValue(), unit);
    }

    private IMeasurable getCoreUnit(String unitName) {

        for (LengthUnit u : LengthUnit.values())
            if (u.getUnitName().equalsIgnoreCase(unitName))
                return u;

        for (WeightUnit u : WeightUnit.values())
            if (u.getUnitName().equalsIgnoreCase(unitName))
                return u;

        for (VolumeUnit u : VolumeUnit.values())
            if (u.getUnitName().equalsIgnoreCase(unitName))
                return u;

        for (TemperatureUnit u : TemperatureUnit.values())
            if (u.getUnitName().equalsIgnoreCase(unitName))
                return u;

        throw new IllegalArgumentException("Invalid unit: " + unitName);
    }

    @Override
    public QuantityDTO compare(QuantityDTO q1, QuantityDTO q2) {

        Quantity<IMeasurable> quantity1 = toQuantity(q1);
        Quantity<IMeasurable> quantity2 = toQuantity(q2);

        boolean result = quantity1.equals(quantity2);

        return new QuantityDTO(
                result ? 1.0 : 0.0,
                "RESULT",
                "Comparison"
        );
    }

    // 🔥 CIRCUIT BREAKER + FEIGN
    @Override
    @CircuitBreaker(name = "userService", fallbackMethod = "fallbackConvert")
    public QuantityDTO convert(QuantityDTO quantityDTO, String targetUnit) {

        Quantity<IMeasurable> quantity = toQuantity(quantityDTO);
        IMeasurable coreTargetUnit = getCoreUnit(targetUnit);
        Quantity<IMeasurable> result = quantity.convertTo(coreTargetUnit);

        String message = "Converted " + quantityDTO.getValue() + " " + quantityDTO.getUnit()
                + " to " + result.getValue() + " " + targetUnit;

        // 🔥 Feign call
        userServiceClient.saveHistory(1L, message);

        return new QuantityDTO(
                result.getValue(),
                targetUnit,
                quantityDTO.getMeasurementType()
        );
    }

    // 🔥 FALLBACK METHOD
    public QuantityDTO fallbackConvert(QuantityDTO quantityDTO, String targetUnit, Exception ex) {

        System.out.println("🔥 FALLBACK TRIGGERED: " + ex.getMessage());

        Quantity<IMeasurable> quantity = toQuantity(quantityDTO);
        IMeasurable coreTargetUnit = getCoreUnit(targetUnit);
        Quantity<IMeasurable> result = quantity.convertTo(coreTargetUnit);

        return new QuantityDTO(
                result.getValue(),
                targetUnit,
                quantityDTO.getMeasurementType()
        );
    }

    @Override
    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {

        Quantity<IMeasurable> quantity1 = toQuantity(q1);
        Quantity<IMeasurable> quantity2 = toQuantity(q2);

        Quantity<IMeasurable> result = quantity1.add(quantity2);

        return new QuantityDTO(
                result.getValue(),
                q1.getUnit(),
                q1.getMeasurementType()
        );
    }

    @Override
    public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2) {

        Quantity<IMeasurable> quantity1 = toQuantity(q1);
        Quantity<IMeasurable> quantity2 = toQuantity(q2);

        Quantity<IMeasurable> result = quantity1.subtract(quantity2);

        return new QuantityDTO(
                result.getValue(),
                q1.getUnit(),
                q1.getMeasurementType()
        );
    }

    @Override
    public double divide(QuantityDTO q1, QuantityDTO q2) {

        Quantity<IMeasurable> quantity1 = toQuantity(q1);
        Quantity<IMeasurable> quantity2 = toQuantity(q2);

        return quantity1.divide(quantity2);
    }

    @Override
    public List<QuantityDTO> getOperationHistory(OperationType operation) {
        return List.of();
    }

    @Override
    public long getOperationCount(OperationType operation) {
        return 0;
    }

    @Override
    public List<QuantityDTO> getErrorOperations() {
        return List.of();
    }
}