package org.example.auth_multiplatform_service.model.service;

import org.example.auth_multiplatform_service.model.entity.UserEntity;
import org.example.auth_multiplatform_service.model.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
public interface AdminService {
    List<UserEntity> findAllUsers();

    //                       Admin methode
    boolean deleteUser(long  id);

    UserEntity updateUser(long idToUpdate, UserEntity user) throws UserNotFoundException;

    UserEntity insertUser(UserEntity user);

}
