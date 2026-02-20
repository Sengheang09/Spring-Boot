package com.example.springfullstructure.service;

import com.example.springfullstructure.dto.request_dto.CategoryRequestDto;
import com.example.springfullstructure.dto.response_dto.CategoryResponseDto;
import com.example.springfullstructure.entity.CategoryEntity;
import com.example.springfullstructure.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface CategoryService {
    ResponseEntity<ApiResponse<CategoryResponseDto>> addCategory(CategoryRequestDto category);
}
