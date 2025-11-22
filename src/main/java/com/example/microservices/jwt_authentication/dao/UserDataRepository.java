package com.example.microservices.jwt_authentication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserDataEntity, String> {
    UserDataEntity findByUsername(String username);
}
