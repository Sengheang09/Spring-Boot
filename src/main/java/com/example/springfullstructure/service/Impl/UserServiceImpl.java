package com.example.springfullstructure.service.Impl;

import com.example.springfullstructure.entity.RoleEntity;
import com.example.springfullstructure.entity.UserEntity;
import com.example.springfullstructure.repo.RoleRepository;
import com.example.springfullstructure.repo.UserRepository;
import com.example.springfullstructure.service.UserService;
import com.example.springfullstructure.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public ResponseEntity<ApiResponse<UserEntity>> register(UserEntity user) {
        boolean existUser = userRepository.existsByEmail(user.getEmail());

        if (existUser) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse<>(
                    false,
                    "this email is exist.",
                    null
            ));
        }

        if(user.getUsername().isEmpty()|| user.getUsername().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(
                    false,"username is required",null
            ));
        }

        if(!user.getUsername().matches("^[a-zA-Z ]+$")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(
                    false,"username must be character",null
            ));
        }

        if(user.getEmail().isEmpty() || user.getEmail().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(
                    false,"email is required",null
            ));
        }

        if(!user.getEmail().matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.(com|edu|gov|org)\\.kh$\n")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ApiResponse<>(false,"email must be email", null)
            );
        }

        if(user.getPassword().isEmpty() || user.getPassword().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(
                    false,"password is required",null
            ));
        }
        if (!user.getPassword().matches(
                "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$"
        )) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(
                            false,
                            "Password must be at least 8 characters and include 1 uppercase letter, 1 lowercase letter, 1 number, and 1 special character.",
                            null
                    ));
        }

        //get role from role table(db)
        Optional<RoleEntity> findRole = roleRepository.findByName("ROLE_USER");
        if(!findRole.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ApiResponse<>(false,"role user not found", null)
            );
        }

        //get data to normal object
        RoleEntity getRole = findRole.get();

        //assign default role
        user.setRole(getRole);
        UserEntity save = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(
                true,"user register successful",save
        ));

    }
}
