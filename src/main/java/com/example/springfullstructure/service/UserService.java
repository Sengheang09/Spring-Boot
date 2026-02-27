package com.example.springfullstructure.service;

import com.example.springfullstructure.entity.UserEntity;
import com.example.springfullstructure.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResponseEntity<ApiResponse<UserEntity>> register(UserEntity user);
}
