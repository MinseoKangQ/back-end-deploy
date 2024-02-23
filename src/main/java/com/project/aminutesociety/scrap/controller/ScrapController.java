package com.project.aminutesociety.scrap.controller;

import com.project.aminutesociety.scrap.service.ScrapServiceImpl;
import com.project.aminutesociety.util.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Scrap", description = "스크립 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/scrap")
public class ScrapController {

    private final ScrapServiceImpl scrapService;

    @Operation(summary = "스크랩")
    @PostMapping("{userId}/{videoId}")
    public ResponseEntity<ApiResponse<?>> createScrap(@PathVariable("userId") String userId, @PathVariable("videoId") Long videoId) {
        ResponseEntity<ApiResponse<?>> result = scrapService.createScrap(userId, videoId);
        return result;
    }

    @Operation(summary = "스크랩 취소")
    @DeleteMapping("{userId}/{videoId}")
    public ResponseEntity<ApiResponse<?>> deleteScrap(@PathVariable("userId") String userId, @PathVariable("videoId") Long videoId) {
        ResponseEntity<ApiResponse<?>> result = scrapService.deleteScrap(userId, videoId);
        return result;
    }

    @Operation(summary = "스크랩 영상 조회")
    @GetMapping("{userId}")
    public ResponseEntity<ApiResponse<?>> getUserScrap(@PathVariable("userId") String userId, @RequestParam("type") String type) {
        ResponseEntity<ApiResponse<?>> result = scrapService.getUserScrap(userId, type);
        return result;
    }
}
