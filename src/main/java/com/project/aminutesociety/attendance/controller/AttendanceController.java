package com.project.aminutesociety.attendance.controller;

import com.project.aminutesociety.attendance.dto.SetAttendanceDto;
import com.project.aminutesociety.attendance.service.AttendanceServiceImpl;
import com.project.aminutesociety.util.response.CustomApiResponse;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "출석 등록")
    @PostMapping("/{userId}")
    public ResponseEntity<CustomApiResponse<?>> setSaveTime(@PathVariable("userId") String userId,
                                                            @RequestBody SetAttendanceDto setAttendanceDto) {
        return attendanceService.setSaveTime(userId, setAttendanceDto);
    }

    // 마이페이지 접속
    @Operation(summary = "마이페이지 접속")
    @GetMapping("/{userId}")
    public ResponseEntity<CustomApiResponse<?>> readAttendanceAll(@PathVariable("userId") String userId) {
        return attendanceService.readAttendanceAll(userId);
    }

    // 마이페이지 캘린더에서 특정 날짜를 클릭
    @Operation(summary = "상세 날짜로 출석 조회")
    @GetMapping("/{userId}/get")
    public ResponseEntity<CustomApiResponse<?>> readAttendance(@PathVariable("userId") String userId, @RequestParam("date") String date) {
        return attendanceService.readAttendance(userId, date);
    }
}
