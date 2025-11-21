package com.example.microservices.jwt_authentication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<UniversityEntity, Integer> {
}
