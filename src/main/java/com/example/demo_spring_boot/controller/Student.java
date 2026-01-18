package com.example.demo_spring_boot.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    private Integer id;

    private String name;

    private String gender;

}
