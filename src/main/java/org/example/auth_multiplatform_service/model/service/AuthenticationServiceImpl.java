package org.example.auth_multiplatform_service.model.service;

import org.example.auth_multiplatform_service.model.entity.RoleEntity;
import org.example.auth_multiplatform_service.model.entity.UserEntity;
import org.example.auth_multiplatform_service.model.repository.RoleRepository;
import org.example.auth_multiplatform_service.model.util.type.RoleEnum;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
   // @Autowired
   // JwtAuthenticationFilter filter;

    public AuthenticationServiceImpl(UserService userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    @Transactional
    public UserEntity register(UserEntity newUser) {
        ArrayList<RoleEntity> roleTemp = new ArrayList<>();

        Optional<RoleEntity> userRole = roleRepository.findByName(RoleEnum.USER.name());
        userRole.ifPresent(roleTemp::add);

        if (newUser.isAdmin()) {
            Optional<RoleEntity> adminRole = roleRepository.findByName(RoleEnum.ADMIN.name());
            adminRole.ifPresent(roleTemp::add);
        }

        newUser.setRoleEntities(roleTemp);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        return userService.save(newUser);
    }


}
