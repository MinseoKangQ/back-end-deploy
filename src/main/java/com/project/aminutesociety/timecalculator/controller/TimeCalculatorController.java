package com.project.aminutesociety.timecalculator.controller;

import com.project.aminutesociety.timecalculator.dto.SetDistanceDto;
import com.project.aminutesociety.timecalculator.service.TimeCalculatorService;
import com.project.aminutesociety.util.response.ApiResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/distance")
@RequiredArgsConstructor
@RestController
@Transactional
public class TimeCalculatorController {

    private final TimeCalculatorService timeCalculatorService;

    @GetMapping("")
    public String hello(){
        return "hello";
    }
    @GetMapping("/get")
    public ResponseEntity<ApiResponse<?>> getTime(@RequestParam String distance, @RequestParam String arrive) {
        return timeCalculatorService.getTime(distance, arrive);

    }
}
