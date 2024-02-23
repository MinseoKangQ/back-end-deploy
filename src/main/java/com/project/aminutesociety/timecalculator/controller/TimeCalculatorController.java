package com.project.aminutesociety.timecalculator.controller;

//import com.project.aminutesociety.timecalculator.dto.SetDistanceDto;
import com.project.aminutesociety.timecalculator.service.TimeCalculatorService;
import com.project.aminutesociety.util.response.CustomApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name = "TimeCalculator", description = "거리별 소요시간 관련 API")
@RequestMapping("/api/distance")
@RequiredArgsConstructor
@RestController
@Transactional
public class TimeCalculatorController {

    private final TimeCalculatorService timeCalculatorService;

    @Operation(summary = "거리별 소요시간 조회")
    @GetMapping("/get")
    public ResponseEntity<CustomApiResponse<?>> getTime(@RequestParam String distance, @RequestParam String arrive) {
        return timeCalculatorService.getTime(distance, arrive);

    }
}
