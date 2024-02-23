package com.project.aminutesociety.test;

import com.project.aminutesociety.util.response.CustomApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Test", description = "테스트 API")
@RestController
@RequestMapping("api/test")
public class TestController {

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "GET 테스트 성공",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CustomApiResponse.class),
                            examples = @ExampleObject(
                                    value = "{\"status\": 200, \"data\": null, \"message\": \"GET 테스트 컨트롤러 성공!!\"}"
                            )
                    )
            )
    })
    @Operation(summary = "GET 테스트")
    @GetMapping("get")
    public ResponseEntity<CustomApiResponse<?>> getTestController() {
        CustomApiResponse<Object> successWithoutData = CustomApiResponse.createSuccessWithoutData(HttpStatus.OK.value(), "GET 테스트 컨트롤러 성공!!");
        return ResponseEntity.status(HttpStatus.OK).body(successWithoutData);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "POST 테스트 성공",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CustomApiResponse.class),
                            examples = @ExampleObject(
                                    value = "{\"status\": 201, \"data\": null, \"message\": \"POST 테스트 컨트롤러 성공!!\"}"
                            )
                    )
            )
    })
    @Operation(summary = "POST 테스트")
    @PostMapping("post")
    public ResponseEntity<CustomApiResponse<?>> postTestController() {
        CustomApiResponse<Object> successWithoutData = CustomApiResponse.createSuccessWithoutData(HttpStatus.CREATED.value(), "POST 테스트 컨트롤러 성공!!");
        return ResponseEntity.status(HttpStatus.CREATED).body(successWithoutData);
    }
}
