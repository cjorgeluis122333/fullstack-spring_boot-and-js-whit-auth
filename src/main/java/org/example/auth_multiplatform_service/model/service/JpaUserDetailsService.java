package org.example.auth_multiplatform_service.model.service;

import org.example.auth_multiplatform_service.model.entity.UserEntity;
import org.example.auth_multiplatform_service.model.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.example.auth_multiplatform_service.model.util.constant.CustomMessage.*;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    private final UserRepository repository;

    public JpaUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> userOptional = repository.findUserEntitiesByUsername(username);

        if (userOptional.isEmpty())
            throw new UsernameNotFoundException(USERNAME_NOT_EXIST);


        UserEntity user = userOptional.orElseThrow();

        List<GrantedAuthority> authorities = user.getRoleEntities().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return new User(user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                true,
                true,
                true,
                authorities);
    }

}
