package com.project.aminutesociety.scrap.controller;

import com.project.aminutesociety.scrap.service.ScrapServiceImpl;
import com.project.aminutesociety.util.response.CustomApiResponse;
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

@Tag(name = "Scrap", description = "스크립 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/scrap")
public class ScrapController {

    private final ScrapServiceImpl scrapService;

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "스크랩 성공",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\n" +
                                            "    \"status\": 201,\n" +
                                            "    \"data\": null,\n" +
                                            "    \"message\": \"스크랩이 완료되었습니다.\"\n" +
                                            "}"
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "이미 스크랩 한 영상입니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\n" +
                                            "    \"status\": 409,\n" +
                                            "    \"data\": null,\n" +
                                            "    \"message\": \"이미 스크랩 한 영상입니다.\"\n" +
                                            "}"
                            )
                    )
            )
    })
    @Operation(summary = "스크랩")
    @PostMapping("{userId}/{videoId}")
    public ResponseEntity<CustomApiResponse<?>> createScrap(@PathVariable("userId") String userId, @PathVariable("videoId") Long videoId) {
        ResponseEntity<CustomApiResponse<?>> result = scrapService.createScrap(userId, videoId);
        return result;
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202",
                    description = "스크랩 취소 성공",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\n" +
                                            "    \"status\": 202,\n" +
                                            "    \"data\": null,\n" +
                                            "    \"message\": \"스크랩이 취소되었습니다.\"\n" +
                                            "}"
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "스크랩하지 않은 영상입니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\n" +
                                            "    \"status\": 400,\n" +
                                            "    \"data\": null,\n" +
                                            "    \"message\": \"스크랩하지 않은 영상입니다.\"\n" +
                                            "}"
                            )
                    )
            )
    })
    @Operation(summary = "스크랩 취소")
    @DeleteMapping("{userId}/{videoId}")
    public ResponseEntity<CustomApiResponse<?>> deleteScrap(@PathVariable("userId") String userId, @PathVariable("videoId") Long videoId) {
        ResponseEntity<CustomApiResponse<?>> result = scrapService.deleteScrap(userId, videoId);
        return result;
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "스크랩 영상 조회 성공",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CustomApiResponse.class),
                            examples = @ExampleObject(
                                    value = "{\n" +
                                            "    \"status\": 200,\n" +
                                            "    \"data\": {\n" +
                                            "        \"scraps\": [\n" +
                                            "            {\n" +
                                            "                \"categoryId\": 1,\n" +
                                            "                \"videoId\": 1,\n" +
                                            "                \"videoTitle\": \"IT 제목1\",\n" +
                                            "                \"videoRunTime\": \"00:09:27\",\n" +
                                            "                \"url\": \"https://a-minute-society.s3.ap-northeast-2.amazonaws.com/videos/example.mp4\",\n" +
                                            "                \"thumbnail\": \"https://a-minute-society.s3.ap-northeast-2.amazonaws.com/+thumbnail/test-thumnail.png\"\n" +
                                            "            }\n" +
                                            "        ]\n" +
                                            "    },\n" +
                                            "    \"message\": \"스크랩 영상이 정상적으로 조회되었습니다.\"\n" +
                                            "}"
                            )
                    )
            )
    })
    @Operation(summary = "스크랩 영상 조회")
    @GetMapping("{userId}")
    public ResponseEntity<CustomApiResponse<?>> getUserScrap(@PathVariable("userId") String userId, @RequestParam("type") String type) {
        ResponseEntity<CustomApiResponse<?>> result = scrapService.getUserScrap(userId, type);
        return result;
    }
}
