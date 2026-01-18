package com.example.demo_spring_boot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping
    public String test(
        @RequestParam String name,
        @RequestParam String gender
    ){
        return "Name :" + name +"\tGender: "+ gender;
    }

    // dynamic endpoint
    @GetMapping("/{id}") // jab tam dynamic roud
    public String test2(@PathVariable Integer id){
        return "ID: " + id;
    }
    @GetMapping("/name/{name}")
    public String test3(@PathVariable String name){
        return "name: " + name;

    }

}
