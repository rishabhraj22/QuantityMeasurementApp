package com.apps.quantitymeasurement.service;

import java.util.List;

import com.apps.quantitymeasurement.model.QuantityDTO;
import com.apps.quantitymeasurement.model.OperationType;

public interface IQuantityMeasurementService {

    QuantityDTO compare(QuantityDTO q1, QuantityDTO q2);

    QuantityDTO convert(QuantityDTO quantity, String targetUnit);

    QuantityDTO add(QuantityDTO q1, QuantityDTO q2);

    QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2);

    double divide(QuantityDTO q1, QuantityDTO q2);

    List<QuantityDTO> getOperationHistory(OperationType operation);

    long getOperationCount(OperationType operation);

    List<QuantityDTO> getErrorOperations();
}