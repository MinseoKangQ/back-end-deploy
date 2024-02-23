package com.project.aminutesociety.scrap.controller;

import com.project.aminutesociety.scrap.service.ScrapServiceImpl;
import com.project.aminutesociety.util.response.CustomApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "스크랩 성공"),
            @ApiResponse(responseCode = "409", description = "스크랩 실패")
    })
    @Operation(summary = "스크랩")
    @PostMapping("{userId}/{videoId}")
    public ResponseEntity<CustomApiResponse<?>> createScrap(@PathVariable("userId") String userId, @PathVariable("videoId") Long videoId) {
        ResponseEntity<CustomApiResponse<?>> result = scrapService.createScrap(userId, videoId);
        return result;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "스크랩 취소 성공"),
            @ApiResponse(responseCode = "400", description = "스크랩 취소 실패")
    })
    @Operation(summary = "스크랩 취소")
    @DeleteMapping("{userId}/{videoId}")
    public ResponseEntity<CustomApiResponse<?>> deleteScrap(@PathVariable("userId") String userId, @PathVariable("videoId") Long videoId) {
        ResponseEntity<CustomApiResponse<?>> result = scrapService.deleteScrap(userId, videoId);
        return result;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "스크랩 조회 성공")
    })
    @Operation(summary = "스크랩 영상 조회")
    @GetMapping("{userId}")
    public ResponseEntity<CustomApiResponse<?>> getUserScrap(@PathVariable("userId") String userId, @RequestParam("type") String type) {
        ResponseEntity<CustomApiResponse<?>> result = scrapService.getUserScrap(userId, type);
        return result;
    }
}
