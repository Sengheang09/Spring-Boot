package com.example.springfullstructure.repo;

import com.example.springfullstructure.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleRepository, Long> {
    Optional<RoleEntity> findByName(String name);
}
