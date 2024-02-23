package com.project.aminutesociety.test;

import com.project.aminutesociety.util.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "GET 테스트")
    @GetMapping("get")
    public ResponseEntity<ApiResponse<?>> getTestController() {
        ApiResponse<Object> successWithoutData = ApiResponse.createSuccessWithoutData(HttpStatus.OK.value(), "GET 테스트 컨트롤러 성공!!");
        return ResponseEntity.status(HttpStatus.OK).body(successWithoutData);
    }

    @Operation(summary = "POST 테스트")
    @PostMapping("post")
    public ResponseEntity<ApiResponse<?>> postTestController() {
        ApiResponse<Object> successWithoutData = ApiResponse.createSuccessWithoutData(HttpStatus.OK.value(), "POST 테스트 컨트롤러 성공!!");
        return ResponseEntity.status(HttpStatus.OK).body(successWithoutData);
    }
}
