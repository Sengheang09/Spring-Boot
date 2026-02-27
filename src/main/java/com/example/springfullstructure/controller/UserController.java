package com.example.springfullstructure.controller;

import com.example.springfullstructure.entity.UserEntity;
import com.example.springfullstructure.service.Impl.CategoryServiceImpl;
import com.example.springfullstructure.service.Impl.UserServiceImpl;
import com.example.springfullstructure.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mini-shop/user")
public class UserController {
    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserEntity>> register(@RequestBody UserEntity user){
        return userService.register(user);
    }

}
