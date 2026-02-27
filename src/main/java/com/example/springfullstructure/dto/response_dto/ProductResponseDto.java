package com.example.springfullstructure.dto.response_dto;

import com.example.springfullstructure.entity.CategoryEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductResponseDto {
    private Long id;

    private String name;

    private BigDecimal price;

    private CategoryEntity category;

    private String imageUrl;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
