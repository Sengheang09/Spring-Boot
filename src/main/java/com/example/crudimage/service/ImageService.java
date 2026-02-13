package com.example.crudimage.service;

import com.example.crudimage.entity.ImageEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    ResponseEntity<ImageEntity> uploadImages(ImageEntity image , MultipartFile file) throws IOException;

    ResponseEntity<List<ImageEntity>> showAllImage();

    ResponseEntity<ImageEntity> findImageById(Long id);

    ResponseEntity<ImageEntity> updateImageById(ImageEntity image , Long id , MultipartFile file) throws IOException;

    ResponseEntity<?> removeImageById(Long id);
}
