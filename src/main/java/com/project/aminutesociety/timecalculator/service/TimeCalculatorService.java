package com.project.aminutesociety.timecalculator.service;

import com.project.aminutesociety.timecalculator.dto.SetDistanceDto;
import com.project.aminutesociety.util.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface TimeCalculatorService {
    ResponseEntity<ApiResponse<?>> getTime(String distance, String arrive);
}
