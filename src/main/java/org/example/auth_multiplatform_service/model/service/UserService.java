package org.example.auth_multiplatform_service.model.service;

import org.example.auth_multiplatform_service.model.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> findAllUsers();
    Optional<UserEntity> findByUsername(String username);
    boolean existsByUsername(String username);
    UserEntity save(UserEntity user);
}
