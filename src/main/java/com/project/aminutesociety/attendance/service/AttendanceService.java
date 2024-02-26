package com.project.aminutesociety.attendance.service;

import com.project.aminutesociety.attendance.dto.SetAttendanceDto;
import com.project.aminutesociety.util.response.CustomApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AttendanceService {
    ResponseEntity<CustomApiResponse<?>> setSaveTime(String userId, SetAttendanceDto setAttendanceDto);

    ResponseEntity<CustomApiResponse<?>> readAttendanceAll(String userId);

    ResponseEntity<CustomApiResponse<?>> readAttendance(String userId, String date);
}