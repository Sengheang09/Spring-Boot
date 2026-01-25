package com.example.spring_data_jpa.service.Impl;

import com.example.spring_data_jpa.entity.ApiResponse;
import com.example.spring_data_jpa.entity.Employee;
import com.example.spring_data_jpa.repo.EmployeeRepository;
import com.example.spring_data_jpa.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository empRepo;
    public EmployeeServiceImpl(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }

    @Override
    public ResponseEntity<ApiResponse<Employee>> createEmployee(Employee emp) {
//        emp.setCreatedAt(LocalDateTime.now());
//        emp.setUpdatedAt(LocalDateTime.now());

        // 1. check duplicate data
        boolean exists = empRepo.existsByEmail(emp.getEmail());
        if(exists){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse<>(
                    "this email already exists",409,null
            ));
        }
        Employee savedEmp = empRepo.save(emp);


        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(
                "create new resouce success",201,savedEmp
        ));
    }

    @Override
    public ResponseEntity<ApiResponse<List<Employee>>> showAll() {
        List<Employee> getAll = empRepo.findAll();
        if (getAll.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok().body(new ApiResponse<>(
                "all Employee",
                200,
                getAll
        ));
    }
}
