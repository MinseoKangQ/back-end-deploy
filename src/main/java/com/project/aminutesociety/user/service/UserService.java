package com.project.aminutesociety.user.service;

import com.project.aminutesociety.user.dto.ChangeTimeDto;
import com.project.aminutesociety.user.dto.UserLoginRequestDto;
import com.project.aminutesociety.user.dto.UserSignUpDto;
import com.project.aminutesociety.util.response.CustomApiResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<CustomApiResponse<?>> signUp(UserSignUpDto.Req req);
    ResponseEntity<CustomApiResponse<?>> login(UserLoginRequestDto userLoginDto);

    ResponseEntity<CustomApiResponse<?>> checkUserId(String userId);

    ResponseEntity<CustomApiResponse<?>> userInfo(String userId);

    ResponseEntity<CustomApiResponse<?>> changeTime(String userId, ChangeTimeDto changeTimeDto);

    ResponseEntity<CustomApiResponse<?>> SignOut(String userId);
}
