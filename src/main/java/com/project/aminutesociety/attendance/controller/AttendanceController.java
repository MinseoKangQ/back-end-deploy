package com.project.aminutesociety.attendance.controller;

import com.project.aminutesociety.attendance.dto.SetAttendanceDto;
import com.project.aminutesociety.attendance.service.AttendanceServiceImpl;
import com.project.aminutesociety.util.response.CustomApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Attendance", description = "출석 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/attendance")
public class AttendanceController {
    private final AttendanceServiceImpl attendanceService;

    // 영상 시청 후 틈새시간 증가 및 출석 확인
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "출석이 기록되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\n" +
                                            "    \"status\": 201,\n" +
                                            "    \"data\": null,\n" +
                                            "    \"message\": \"출석이 기록되었습니다.\"\n" +
                                            "}"
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "잘못된 영상 ID 또는 존재하지 않는 사용자",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {
                                    @ExampleObject(
                                            name = "잘못된 영상 ID",
                                            value = "{\n" +
                                                    "    \"status\": 404,\n" +
                                                    "    \"data\": null,\n" +
                                                    "    \"message\": \"id가 34인 영상은 존재하지 않습니다.\"\n" +
                                                    "}"
                                    ),
                                    @ExampleObject(
                                            name = "존재하지 않는 사용자",
                                            value = "{\n" +
                                                    "    \"status\": 404,\n" +
                                                    "    \"data\": null,\n" +
                                                    "    \"message\": \"kim0403인 사용자는 존재하지 않습니다.\"\n" +
                                                    "}"
                                    )
                            }
                    )
            )
    })
    @Operation(summary = "출석 등록")
    @PostMapping("/{userId}")
    public ResponseEntity<CustomApiResponse<?>> setSaveTime(@PathVariable("userId") String userId,
                                                            @RequestBody SetAttendanceDto setAttendanceDto) {
        return attendanceService.setSaveTime(userId, setAttendanceDto);
    }

    // 마이페이지 접속
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "마이페이지 API 호출 성공",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\n" +
                                            "    \"status\": 200,\n" +
                                            "    \"data\": {\n" +
                                            "        \"totalTime\": \"02:13:20\",\n" +
                                            "        \"calendar\": [\n" +
                                            "            {\n" +
                                            "                \"attendanceId\": 1,\n" +
                                            "                \"date\": \"2024-02-16\",\n" +
                                            "                \"accumulatedTime\": \"01:06:40\"\n" +
                                            "            },\n" +
                                            "            {\n" +
                                            "                \"attendanceId\": 2,\n" +
                                            "                \"date\": \"2024-02-17\",\n" +
                                            "                \"accumulatedTime\": \"01:06:40\"\n" +
                                            "            }\n" +
                                            "        ]\n" +
                                            "    },\n" +
                                            "    \"message\": \"마이페이지 API 호출 성공\"\n" +
                                            "}"
                            )
                    )
            )
    })
    @Operation(summary = "마이페이지 접속")
    @GetMapping("/{userId}")
    public ResponseEntity<CustomApiResponse<?>> readAttendanceAll(@PathVariable("userId") String userId) {
        return attendanceService.readAttendanceAll(userId);
    }

    // 마이페이지 캘린더에서 특정 날짜를 클릭
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "해당 날짜의 기록이 정상적으로 조회되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\n" +
                                            "    \"status\": 200,\n" +
                                            "    \"data\": [\n" +
                                            "        {\"videoId\": 1, \"categoryId\": 1, \"url\": \"https://example.com/1/video1\", \"thumbnail\": \"\", \"title\": \"IT 영상1\", \"scrap\": true},\n" +
                                            "        {\"videoId\": 2, \"categoryId\": 1, \"url\": \"https://example.com/1/video2\", \"thumbnail\": \"\", \"title\": \"IT 영상2\", \"scrap\": true},\n" +
                                            "        {\"videoId\": 3, \"categoryId\": 1, \"url\": \"https://example.com/1/video3\", \"thumbnail\": \"\", \"title\": \"IT 영상3\", \"scrap\": true},\n" +
                                            "        {\"videoId\": 10, \"categoryId\": 3, \"url\": \"https://example.com/3/video2\", \"thumbnail\": \"\", \"title\": \"경제 영상2\", \"scrap\": false},\n" +
                                            "        {\"videoId\": 11, \"categoryId\": 3, \"url\": \"https://example.com/3/video3\", \"thumbnail\": \"\", \"title\": \"경제 영상3\", \"scrap\": false}\n" +
                                            "    ],\n" +
                                            "    \"message\": \"해당 날짜의 기록이 정상적으로 조회되었습니다.\"\n" +
                                            "}"
                            )
                    )
            )
    })
    @Operation(summary = "상세 날짜로 출석 조회")
    @GetMapping("/{userId}/get")
    public ResponseEntity<CustomApiResponse<?>> readAttendance(@PathVariable("userId") String userId, @RequestParam("date") String date) {
        return attendanceService.readAttendance(userId, date);
    }
}
