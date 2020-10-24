package com.rad.ecommerceapi.dao;

import com.rad.ecommerceapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface UserRepository extends JpaRepository<User, Long> {
}
