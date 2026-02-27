package com.example.springfullstructure.service.Impl;

import com.example.springfullstructure.dto.request_dto.CategoryRequestDto;
import com.example.springfullstructure.dto.response_dto.CategoryResponseDto;
import com.example.springfullstructure.entity.CategoryEntity;
import com.example.springfullstructure.repo.CategoryRepository;
import com.example.springfullstructure.service.CategoryService;
import com.example.springfullstructure.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public ResponseEntity<ApiResponse<CategoryResponseDto>> addCategory(CategoryRequestDto category) {
        CategoryEntity entity = new CategoryEntity();
        entity.setName(category.getName());

        //save to Db
        CategoryEntity saved = categoryRepository.save(entity);

        //map data from entity
        CategoryResponseDto response = new CategoryResponseDto();
        response.setName(saved.getName());
        response.setId(saved.getId());


        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(
                true,
                "Data has been create successfully",
                response
        ));
    }

    @Override
    public ResponseEntity<ApiResponse<List<CategoryResponseDto>>> viewAllCategories() {

        List<CategoryEntity> allCategories = categoryRepository.findAll();
        if(allCategories.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(
                    false,
                    "no record",
                    null
            ));
        }

        List<CategoryResponseDto> dtoList = new ArrayList<>();

        for(CategoryEntity category : allCategories){
            CategoryResponseDto dto = new CategoryResponseDto();

            dto.setName(category.getName());
            dto.setId(category.getId());

            dtoList.add(dto);
        }

        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(
                true,
                "Success",
                dtoList
        ));
    }

    @Override
    public ResponseEntity<ApiResponse<CategoryResponseDto>> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<CategoryResponseDto>> updateCategory(CategoryRequestDto category, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<CategoryResponseDto>> deleteCategory(Long id) {
        return null;
    }
}
