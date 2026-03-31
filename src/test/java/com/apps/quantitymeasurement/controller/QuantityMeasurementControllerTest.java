package com.apps.quantitymeasurement.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.apps.quantitymeasurement.config.SecurityConfig;
import com.apps.quantitymeasurement.model.QuantityDTO;
import com.apps.quantitymeasurement.service.IQuantityMeasurementService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = QuantityMeasurementController.class)
@AutoConfigureMockMvc(addFilters = false)
@Import(SecurityConfig.class)
public class QuantityMeasurementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IQuantityMeasurementService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCompareSuccess() throws Exception {
        QuantityDTO q1 = new QuantityDTO(1.0, "FEET", "LengthUnit");
        QuantityDTO q2 = new QuantityDTO(12.0, "INCHES", "LengthUnit");

        QuantityDTO result = new QuantityDTO(1.0, "RESULT", "Comparison");

        when(service.compare(any(QuantityDTO.class), any(QuantityDTO.class)))
                .thenReturn(result);

        List<QuantityDTO> input = Arrays.asList(q1, q2);

        mockMvc.perform(post("/api/v1/quantities/compare")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(1.0))
                .andExpect(jsonPath("$.unit").value("RESULT"))
                .andExpect(jsonPath("$.measurementType").value("Comparison"));
    }

    @Test
    void testAddSuccess() throws Exception {
        QuantityDTO q1 = new QuantityDTO(1.0, "FEET", "LengthUnit");
        QuantityDTO q2 = new QuantityDTO(12.0, "INCHES", "LengthUnit");

        QuantityDTO result = new QuantityDTO(2.0, "FEET", "LengthUnit");

        when(service.add(any(QuantityDTO.class), any(QuantityDTO.class)))
                .thenReturn(result);

        List<QuantityDTO> input = Arrays.asList(q1, q2);

        mockMvc.perform(post("/api/v1/quantities/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(2.0))
                .andExpect(jsonPath("$.unit").value("FEET"))
                .andExpect(jsonPath("$.measurementType").value("LengthUnit"));
    }
}