package com.project.aminutesociety.user.dto;

import com.project.aminutesociety.category.dto.CategoryResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class UserLoginResponseDto {
    private Long id;
    private String userId;
    private String userName;
}
