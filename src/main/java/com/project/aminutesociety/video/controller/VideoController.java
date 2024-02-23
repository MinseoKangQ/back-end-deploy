package com.project.aminutesociety.video.controller;

import com.project.aminutesociety.util.response.CustomApiResponse;
import com.project.aminutesociety.video.dto.EditRecommendVideo;
import com.project.aminutesociety.video.service.VideoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Video", description = "영상 관련 API")
@RestController
@RequestMapping("api/video")
@RequiredArgsConstructor
public class VideoController {

    private final VideoServiceImpl videoService;

    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "영상 추천 성공")
    })
    @Operation(summary = "출발지/도착지 설정 후 영상 추천")
    @GetMapping("recommend/{userId}")
    public ResponseEntity<CustomApiResponse<?>> recommendVideo(@PathVariable("userId") String userId, @RequestParam("time") Integer time) {
        ResponseEntity<CustomApiResponse<?>> result = videoService.recommendVideo(userId, time);
        return result;
    }

    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "영상 추천 수정 성공")
    })
    @Operation(summary = "추천 영상 1개 수정")
    @PutMapping("recommend/{userId}")
    public ResponseEntity<CustomApiResponse<?>> editRecommendVideo(@PathVariable("userId") String userId,
                                                                   @RequestParam("time") Integer time,
                                                                   @RequestBody EditRecommendVideo.Req req) {
        ResponseEntity<CustomApiResponse<?>> result = videoService.editRecommendVideo(userId, time, req);
        return result;
    }

    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "홈에서 사용자 카테고리 기반의 영상 추천 성공")
    })
    @Operation(summary = "홈에서 사용자 카테고리 기반의 영상 추천")
    @GetMapping("home/recommend/{userId}")
    public ResponseEntity<CustomApiResponse<?>> getVideoRecommend(@PathVariable("userId") String userId) {
        ResponseEntity<CustomApiResponse<?>> result = videoService.getVideoRecommend(userId);
        return result;
    }
}
