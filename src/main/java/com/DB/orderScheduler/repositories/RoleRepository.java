package com.DB.orderScheduler.repositories;

import com.DB.orderScheduler.models.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByType(String type);
}
