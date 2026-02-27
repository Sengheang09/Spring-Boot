package com.example.springfullstructure.repo;

import com.example.springfullstructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    boolean existsByEmail(String email);
}
