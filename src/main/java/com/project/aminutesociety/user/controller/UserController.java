package com.project.aminutesociety.user.controller;

import com.project.aminutesociety.user.dto.ChangeTimeDto;
import com.project.aminutesociety.user.dto.UserLoginRequestDto;
import com.project.aminutesociety.user.dto.UserSignUpDto;
import com.project.aminutesociety.user.service.UserService;
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
@Tag(name = "User", description = "유저 관련 API")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회원가입 성공",
                    content = @Content(examples = @ExampleObject(value = "{\n    \"status\": 200,\n    \"data\": {\n        \"id\": 1,\n        \"userName\": \"유저이름\",\n        \"userId\": \"thisIsTestId\"\n    },\n    \"message\": \"회원가입이 정상적으로 처리되었습니다.\"\n}")
                    , schema = @Schema(implementation = CustomApiResponse.class))),
            @ApiResponse(responseCode = "400", description = "이미 아이디가 존재합니다.",
                    content = @Content(examples = @ExampleObject(value = "{\n    \"status\": 400,\n    \"data\": null,\n    \"message\": \"이미 아이디가 존재합니다.\"\n}")
                    , schema = @Schema(implementation = CustomApiResponse.class))),
    })
    @Operation(summary = "회원 가입")
    @PostMapping("/signup")
    public ResponseEntity<CustomApiResponse<?>> signUp(@RequestBody UserSignUpDto.Req req) {
        ResponseEntity<CustomApiResponse<?>> result = userService.signUp(req);
        return result;
    }

    // 로그인
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "로그인 성공",
                    content = @Content(mediaType = "application/json", examples = @ExampleObject(value = "{\n" + "    \"status\": 200,\n" + "    \"data\": {\n" + "        \"id\": 1,\n" + "        \"userId\": \"유저이름\",\n" + "        \"userName\": \"thisIsTestId\"\n" + "    },\n" +  "    \"message\": \"로그인이 완료되었습니다.\"\n" + "}")
                    , schema = @Schema(implementation = CustomApiResponse.class))
            )
    })
    @Operation(summary = "로그인")
    @PostMapping("/login")
    public ResponseEntity<CustomApiResponse<?>> login(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        ResponseEntity<CustomApiResponse<?>> result = userService.login(userLoginRequestDto);
        return result;
    }


    // userId 존재 확인
    @Operation(summary = "userId로 유저 조회")
    @GetMapping("/{userId}")
    public ResponseEntity<CustomApiResponse<?>> checkUserId(@PathVariable String userId) {
        ResponseEntity<CustomApiResponse<?>> result = userService.checkUserId(userId);
        return result;
    }

    // 설정된 카테고리 확인 및 유저 정보 추가 응답 필요
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "사용자 정보 조회 성공",
                    content = @Content(mediaType = "application/json", examples = @ExampleObject(value = "{\n" + "    \"status\": 200,\n" + "    \"data\": {\n" + "        \"id\": 1,\n" + "        \"userId\": \"thisIsTestId\",\n" + "        \"userName\": \"유저이름\",\n" + "        \"time\": 6000,\n" + "        \"userCategories\": [\n" + "            {\n" + "                \"categoryId\": 2,\n" + "                \"categoryName\": \"경제/금융\"\n" + "            },\n" + "            {\n" + "                \"categoryId\": 4,\n" + "                \"categoryName\": \"요리/베이킹\"\n" + "            },\n" + "            {\n" + "                \"categoryId\": 6,\n" + "                \"categoryName\": \"사진/영상\"\n" + "            },\n" + "            {\n" + "                \"categoryId\": 9,\n" + "                \"categoryName\": \"디자인\"\n" + "            }\n" + "        ]\n" + "    },\n" + "    \"message\": \"사용자 정보 조회가 완료되었습니다.\"\n" + "}")
                    , schema = @Schema(implementation = CustomApiResponse.class)
                    )
            )
    })
    @Operation(summary = "유저의 관심분야 조회")
    @GetMapping("/{userId}/user-info")
    public ResponseEntity<CustomApiResponse<?>> userInfo(@PathVariable String userId) {
        ResponseEntity<CustomApiResponse<?>> result = userService.userInfo(userId);
        return result;
    }

    // 소요시간 변경
    @Operation(summary = "유저의 소요시간 변경")
    @PutMapping("/{userId}/change-time")
    public ResponseEntity<CustomApiResponse<?>> changeTime(@PathVariable String userId, @RequestBody ChangeTimeDto changeTimeDto) {
        ResponseEntity<CustomApiResponse<?>> result = userService.changeTime(userId, changeTimeDto);
        return result;
    }

    // 회원 탈퇴
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "회원탈퇴 성공",
                    content = @Content(examples = @ExampleObject(value = "{\n    \"status\": 202,\n    \"data\": null,\n    \"message\": \"회원탈퇴가 정상적으로 처리되었습니다.\"\n}")
                            , schema = @Schema(implementation = CustomApiResponse.class))),
            @ApiResponse(responseCode = "404", description = "사용자 존재하지 않음",
                    content = @Content(examples = @ExampleObject(value = "{\n    \"status\": 404,\n    \"data\": null,\n    \"message\": \"thisIsTestId인 사용자는 존재하지 않습니다.\"\n}")
                            , schema = @Schema(implementation = CustomApiResponse.class)))
    })
    @Operation(summary = "회원 탈퇴")
    @DeleteMapping("/{userId}/signout")
    public ResponseEntity<CustomApiResponse<?>> logout(@PathVariable String userId) {
        ResponseEntity<CustomApiResponse<?>> result = userService.SignOut(userId);
        return result;
    }

}
