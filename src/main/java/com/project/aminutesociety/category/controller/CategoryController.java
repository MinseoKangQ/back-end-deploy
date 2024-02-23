package com.project.aminutesociety.category.controller;

import com.project.aminutesociety.category.dto.CategorySetDto;
import com.project.aminutesociety.category.service.CategoryServiceImpl;
import com.project.aminutesociety.util.response.CustomApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Category", description = "관심분야 관련 API")
@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@Transactional
public class CategoryController {

    private final CategoryServiceImpl categoryServiceImpl;

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "카테고리 전체 조회 성공",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\n" +
                                            "    \"status\": 200,\n" +
                                            "    \"data\": [\n" +
                                            "        {\"categoryId\": 1, \"categoryName\": \"IT\"},\n" +
                                            "        {\"categoryId\": 2, \"categoryName\": \"경제/금융\"},\n" +
                                            "        {\"categoryId\": 3, \"categoryName\": \"라이프스타일\"},\n" +
                                            "        {\"categoryId\": 4, \"categoryName\": \"요리/베이킹\"},\n" +
                                            "        {\"categoryId\": 5, \"categoryName\": \"운동/헬스\"},\n" +
                                            "        {\"categoryId\": 6, \"categoryName\": \"사진/영상\"},\n" +
                                            "        {\"categoryId\": 7, \"categoryName\": \"프로그래밍\"},\n" +
                                            "        {\"categoryId\": 8, \"categoryName\": \"마케팅\"},\n" +
                                            "        {\"categoryId\": 9, \"categoryName\": \"디자인\"},\n" +
                                            "        {\"categoryId\": 10, \"categoryName\": \"명상/마인드셋\"}\n" +
                                            "    ],\n" +
                                            "    \"message\": \"카테고리 조회가 완료되었습니다.\"\n" +
                                            "}"
                            ),
                            schema = @Schema(implementation = CustomApiResponse.class)
                    )
            )
    })
    @Operation(summary = "카테고리 전체 조회")
    @GetMapping("/read-all")
    public ResponseEntity<CustomApiResponse<?>> readCategories() {
        return categoryServiceImpl.readCategories();
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "카테고리 설정이 완료되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\"status\": 200, \"data\": null, \"message\": \"카테고리 설정이 완료되었습니다.\"}"
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "잘못된 카테고리 ID 또는 회원 정보",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {
                                    @ExampleObject(
                                            name = "잘못된 카테고리 ID",
                                            value = "{\"status\": 400, \"data\": null, \"message\": \"id가 44인 카테고리가 존재하지 않습니다.\"}"
                                    ),
                                    @ExampleObject(
                                            name = "존재하지 않는 회원",
                                            value = "{\"status\": 400, \"data\": null, \"message\": \"회원을 찾을 수 없습니다.\"}"
                                    )
                            }
                    )
            )
    })
    @Operation(summary = "유저 관심분야 설정")
    @PostMapping("/{userId}/set-categories")
    public ResponseEntity<CustomApiResponse<?>> setCategories(@PathVariable String userId, @RequestBody CategorySetDto categorySetDto) {
        return categoryServiceImpl.setCateogires(userId, categorySetDto);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "카테고리 수정이 완료되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\"status\": 200, \"data\": null, \"message\": \"카테고리 수정이 완료되었습니다.\"}"
                            )
                    )
            ),
            // 재사용할 수 있는 응답들은 위의 설정과 유사하게 추가 가능
    })
    @Operation(summary = "유저 관심분야 변경")
    @PutMapping("/{userId}/change-categories")
    public ResponseEntity<CustomApiResponse<?>> changeCategories(@PathVariable String userId, @RequestBody CategorySetDto categorySetDto) {
        return categoryServiceImpl.changeCategories(userId, categorySetDto);
    }
}
