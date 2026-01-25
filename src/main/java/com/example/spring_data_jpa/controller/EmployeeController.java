package com.example.spring_data_jpa.controller;

import com.example.spring_data_jpa.entity.ApiResponse;
import com.example.spring_data_jpa.entity.Employee;
import com.example.spring_data_jpa.service.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl service;

    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> createEmployee(@RequestBody Employee emp) {
        return service.createEmployee(emp);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Employee>>> showAllEmp() {
        return service.showAll();
    }
}
