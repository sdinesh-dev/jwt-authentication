package com.example.microservices.jwt_authentication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByUsername(String username);
}
