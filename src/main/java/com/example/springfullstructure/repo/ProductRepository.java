package com.example.springfullstructure.repo;

import com.example.springfullstructure.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity , Long> {
    boolean existsByName(String name);
}
