package com.example.crudimage.controller;

import com.example.crudimage.entity.ImageEntity;
import com.example.crudimage.service.ImageService;
import com.example.crudimage.service.Impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private ImageServiceImpl service;


    @Autowired
    private ImageService imageService;

    @PostMapping
    public ResponseEntity<ImageEntity> postImage(
            @ModelAttribute("title") String title ,
            @RequestParam("images") MultipartFile file
    ) throws IOException {
        ImageEntity image = new ImageEntity();
        image.setTitle(title);
        return service.uploadImages(image , file);
    }

    @GetMapping
    public ResponseEntity<List<ImageEntity>> getAll(){
        return service.showAllImage();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageEntity> findImageById(@PathVariable Long id){
        return service.findImageById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImageEntity> updateImageById(
            @ModelAttribute ImageEntity image,
            @PathVariable Long id,
            @RequestParam("image") MultipartFile file
    )throws IOException{
        return imageService.updateImageById(image , id , file);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeImage(@PathVariable Long id){
        return imageService.removeImageById(id);
    }
}
