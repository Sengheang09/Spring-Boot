package com.example.springfullstructure.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserRepository,Long> {
}
