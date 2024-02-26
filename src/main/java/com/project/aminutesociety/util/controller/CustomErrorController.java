package com.project.aminutesociety.util.controller;

import com.project.aminutesociety.util.response.CustomApiResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<CustomApiResponse<Object>> handleError(HttpServletRequest request) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(new CustomApiResponse<>(HttpStatus.NOT_FOUND.value(), null, "요청 경로를 찾을 수 없습니다."));
            }
        }

        // 다른 HTTP 오류에 대한 처리
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new CustomApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, "내부 서버 오류가 발생했습니다."));
    }
}
