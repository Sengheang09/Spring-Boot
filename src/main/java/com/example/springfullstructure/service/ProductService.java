package com.example.springfullstructure.service;

import com.example.springfullstructure.dto.request_dto.ProductRequestDto;
import com.example.springfullstructure.dto.response_dto.ProductResponseDto;
import com.example.springfullstructure.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface ProductService {
    ResponseEntity<ApiResponse<ProductResponseDto>> addProduct(ProductRequestDto dto, MultipartFile file) throws IOException;
}
