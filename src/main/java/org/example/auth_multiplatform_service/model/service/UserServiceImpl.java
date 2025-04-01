package org.example.auth_multiplatform_service.model.service;

import org.example.auth_multiplatform_service.model.entity.UserEntity;
import org.example.auth_multiplatform_service.model.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> findAllUsers() {
        return userRepository.findAllUsersEntity().orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findUserEntitiesByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }
}
