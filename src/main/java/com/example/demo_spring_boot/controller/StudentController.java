package com.example.demo_spring_boot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    List<Student> studentList = new ArrayList<>(
            List.of(
                    new Student(1001, "Heang" , "Male"),
                    new Student(1002 , "Cheata" , "Female")
            )
    );



//    public ResponseEntity<List<Student>>
    @GetMapping
    public ResponseEntity<?> showAllStudents(){
        if(studentList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data record");
        }
        return ResponseEntity.ok().body(studentList);
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        // check duplicate data
        boolean existStudent = studentList.stream().anyMatch(stu-> stu.getId().equals(student.getId()));

        if(existStudent){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Student already exist");//409
        }

        if(!(student.getName().matches("^[a-zA-Z]+$"))){ // a to z , A to Z
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body("Student name must be only characters ");

        }

        if(student.getName().length()<5 || student.getName().length()>20){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Student name must be between 5 and 20 characters");
        }

        if(!(student.getGender().matches("^[a-zA-Z]+$"))){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Student gender must be only characters ");
        }

        if(
                !(student.getGender().equalsIgnoreCase("male") ||
                        student.getGender().equalsIgnoreCase("female")
                )
        ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Gender must be male/female");
        }

        // add data into list
        studentList.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
        // use like this cuz we use ResponseEntity to declare function.

    }

}
