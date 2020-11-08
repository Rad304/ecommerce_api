package com.rad.ecommerceapi.dao;

import com.rad.ecommerceapi.entities.ERole;
import com.rad.ecommerceapi.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
