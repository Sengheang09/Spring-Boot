package com.example.springfullstructure.controller;

import com.example.springfullstructure.dto.request_dto.CategoryRequestDto;
import com.example.springfullstructure.dto.response_dto.CategoryResponseDto;
import com.example.springfullstructure.service.Impl.CategoryServiceImpl;
import com.example.springfullstructure.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mini-shop/category")
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryResponseDto>> addCategory(@RequestBody CategoryRequestDto category){
        return categoryService.addCategory(category);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryResponseDto>>> getAllCategory(){
        return categoryService.viewAllCategories();

    }
}
