package org.example.auth_multiplatform_service.model.service;

import org.example.auth_multiplatform_service.model.entity.UserEntity;

public interface AuthenticationService {
    UserEntity register(UserEntity newUser);
}
