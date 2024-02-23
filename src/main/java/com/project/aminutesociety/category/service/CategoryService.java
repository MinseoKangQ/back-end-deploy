package com.project.aminutesociety.category.service;

import com.project.aminutesociety.category.dto.CategorySetDto;
import com.project.aminutesociety.util.response.CustomApiResponse;
import org.springframework.http.ResponseEntity;

public interface CategoryService {

    ResponseEntity<CustomApiResponse<?>> readCategories();

    ResponseEntity<CustomApiResponse<?>> setCateogires(String userId, CategorySetDto categorySetDto);

    ResponseEntity<CustomApiResponse<?>> changeCategories(String userId, CategorySetDto categorySetDto);
}
