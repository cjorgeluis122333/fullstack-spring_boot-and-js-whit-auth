package org.example.auth_multiplatform_service.model.repository;

import org.example.auth_multiplatform_service.model.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(String name);
}
