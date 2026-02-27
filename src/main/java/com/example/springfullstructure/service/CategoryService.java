package com.example.springfullstructure.service;

import com.example.springfullstructure.dto.request_dto.CategoryRequestDto;
import com.example.springfullstructure.dto.response_dto.CategoryResponseDto;
import com.example.springfullstructure.entity.CategoryEntity;
import com.example.springfullstructure.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoryService {
    ResponseEntity<ApiResponse<CategoryResponseDto>> addCategory(CategoryRequestDto category);

    ResponseEntity<ApiResponse<List<CategoryResponseDto>>> viewAllCategories();

    ResponseEntity<ApiResponse<CategoryResponseDto>> findById(Long id);

    ResponseEntity<ApiResponse<CategoryResponseDto>> updateCategory(CategoryRequestDto category , Long id);

    ResponseEntity<ApiResponse<CategoryResponseDto>> deleteCategory(Long id);
}
