package com.project.aminutesociety.timecalculator.controller;

//import com.project.aminutesociety.timecalculator.dto.SetDistanceDto;
import com.project.aminutesociety.timecalculator.service.TimeCalculatorService;
import com.project.aminutesociety.util.response.CustomApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "거리 측정에 성공하였습니다.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomApiResponse.class),
                            examples = @ExampleObject(value = "{\n" + "    \"status\": 200,\n" + "    \"data\": 1955,\n" + "    \"message\": \"거리 측정에 성공하였습니다.\"\n" + "}"
                            )
                    )
            ),
            @ApiResponse(responseCode = "400", description = "거리 측정에 실패하였습니다.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomApiResponse.class),
                            examples = @ExampleObject(value = "{\n" + "    \"status\": 400,\n" + "    \"data\": null,\n" + "    \"message\": \"거리 측정에 실패하였습니다.\"\n" + "}"
                            )
                    )
            )
    })
    @Operation(summary = "거리별 소요시간 조회")
    @GetMapping("/get")
    public ResponseEntity<CustomApiResponse<?>> getTime(@RequestParam String distance, @RequestParam String arrive) {
        return timeCalculatorService.getTime(distance, arrive);
    }
}
