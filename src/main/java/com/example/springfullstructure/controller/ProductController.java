package com.example.springfullstructure.controller;


import com.example.springfullstructure.dto.request_dto.ProductRequestDto;
import com.example.springfullstructure.dto.response_dto.ProductResponseDto;
import com.example.springfullstructure.service.ProductService;
import com.example.springfullstructure.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/mini-shop/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponseDto>> addProduct(
            ProductRequestDto dto, MultipartFile file
    ) throws IOException{
        return productService.addProduct(dto, file);
    }
}
