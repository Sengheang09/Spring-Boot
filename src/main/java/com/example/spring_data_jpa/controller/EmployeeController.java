package com.example.spring_data_jpa.controller;

import com.example.spring_data_jpa.entity.Employee;
import com.example.spring_data_jpa.service.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl service;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
        return service.createEmployee(emp);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> showAllEmp() {
        return service.showAll();
    }
}
