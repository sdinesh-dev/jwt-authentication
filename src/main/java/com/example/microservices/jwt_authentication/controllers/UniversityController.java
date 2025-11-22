package com.example.microservices.jwt_authentication.controllers;

import com.example.microservices.jwt_authentication.dao.UniversityEntity;
import com.example.microservices.jwt_authentication.dao.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {

    @Autowired
    private UniversityRepository universityRepository;

    @PreAuthorize("hasAnyRole('ADMIN','EDITOR')")
    @PostMapping
    public UniversityEntity addUniversity(@RequestBody UniversityEntity universityEntity){
        return universityRepository.save(universityEntity);
    }

    @PreAuthorize("hasAnyRole('ADMIN','EDITOR','USER','PUBLIC')")
    @GetMapping
    public List<UniversityEntity> getUniversities(){
        return universityRepository.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/test")
    public String test() throws Exception {
        return "inn university";
    }
}
