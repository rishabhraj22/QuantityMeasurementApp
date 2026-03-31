package com.apps.quantitymeasurement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apps.quantitymeasurement.model.QuantityMeasurementEntity;

@Repository
public interface QuantityMeasurementRepository extends JpaRepository<QuantityMeasurementEntity, Long> {

    // Find all measurements by operation
    List<QuantityMeasurementEntity> findByOperation(String operation);

    // Find all measurements where operand1 matches
    List<QuantityMeasurementEntity> findByOperand1(String operand1);

    // Find all measurements where result matches
    List<QuantityMeasurementEntity> findByResult(String result);
}