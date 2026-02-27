package com.example.springfullstructure.dto.request_dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequestDto {

    private String name;

    private BigDecimal price;

    Long category;

    private String imageUrl;
}
