package com.project.aminutesociety.video.controller;

import com.project.aminutesociety.util.response.CustomApiResponse;
import com.project.aminutesociety.video.dto.EditRecommendVideo;
import com.project.aminutesociety.video.service.VideoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
            @ApiResponse(
                    responseCode = "200",
                    description = "영상 추천에 성공하였습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CustomApiResponse.class),
                            examples = @ExampleObject(
                                    value = "{\n" +
                                            "    \"status\": 200,\n" +
                                            "    \"data\": {\n" +
                                            "        \"videos\": [\n" +
                                            "            {\n" +
                                            "                \"categoryId\": 2,\n" +
                                            "                \"videoId\": 8,\n" +
                                            "                \"runTime\": \"00:05:00\",\n" +
                                            "                \"url\": \"https://a-minute-society.s3.ap-northeast-2.amazonaws.com/videos/example.mp4\",\n" +
                                            "                \"thumbnail\": \"\",\n" +
                                            "                \"videoTitle\": \"경제 제목4\"\n" +
                                            "            },\n" +
                                            "            ...\n" +
                                            "        ]\n" +
                                            "    },\n" +
                                            "    \"message\": \"영상 추천에 성공하였습니다.\"\n" +
                                            "}"
                            )
                    )
            )
    })

    @Operation(summary = "출발지/도착지 설정 후 영상 추천")
    @GetMapping("recommend/{userId}")
    public ResponseEntity<CustomApiResponse<?>> recommendVideo(@PathVariable("userId") String userId, @RequestParam("time") Integer time) {
        ResponseEntity<CustomApiResponse<?>> result = videoService.recommendVideo(userId, time);
        return result;
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "영상 추천 수정 성공",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CustomApiResponse.class),
                            examples = @ExampleObject(
                                    value = "{\n" +
                                            "    \"status\": 200,\n" +
                                            "    \"data\": {\n" +
                                            "        \"editedVideo\": {\n" +
                                            "            \"categoryId\": 1,\n" +
                                            "            \"videoId\": 1,\n" +
                                            "            \"runTime\": \"00:09:27\",\n" +
                                            "            \"url\": \"https://a-minute-society.s3.ap-northeast-2.amazonaws.com/videos/example.mp4\",\n" +
                                            "            \"thumbnail\": \"https://a-minute-society.s3.ap-northeast-2.amazonaws.com/+thumbnail/test-thumnail.png\",\n" +
                                            "            \"videoTitle\": \"IT 제목1\"\n" +
                                            "        }\n" +
                                            "    },\n" +
                                            "    \"message\": \"영상 추천 수정 성공\"\n" +
                                            "}"
                            )
                    )
            )
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
            @ApiResponse(
                    responseCode = "200",
                    description = "홈에서 사용자 카테고리 기반의 영상 추천에 성공하였습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CustomApiResponse.class),
                            examples = @ExampleObject(
                                    value = "{\n" +
                                            "    \"status\": 200,\n" +
                                            "    \"data\": {\n" +
                                            "        \"videos\": [\n" +
                                            "            {\n" +
                                            "                \"categoryId\": 1,\n" +
                                            "                \"videoId\": 4,\n" +
                                            "                \"runTime\": \"00:08:00\",\n" +
                                            "                \"url\": \"https://example.com/1/video4\",\n" +
                                            "                \"thumbnail\": \"https://a-minute-society.s3.ap-northeast-2.amazonaws.com/thumbnail/test-thumbnail.png\",\n" +
                                            "                \"videoTitle\": \"IT 제목4\"\n" +
                                            "            },\n" +
                                            "            ...\n" +
                                            "        ]\n" +
                                            "    },\n" +
                                            "    \"message\": \"홈에서 사용자 카테고리 기반의 영상 추천에 성공하였습니다.\"\n" +
                                            "}"
                            )
                    )
            )
    })
    @Operation(summary = "홈에서 사용자 카테고리 기반의 영상 추천")
    @GetMapping("home/recommend/{userId}")
    public ResponseEntity<CustomApiResponse<?>> getVideoRecommend(@PathVariable("userId") String userId) {
        ResponseEntity<CustomApiResponse<?>> result = videoService.getVideoRecommend(userId);
        return result;
    }
}
