package com.example.springfullstructure.repo;

import com.example.springfullstructure.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity , Long> {
}
