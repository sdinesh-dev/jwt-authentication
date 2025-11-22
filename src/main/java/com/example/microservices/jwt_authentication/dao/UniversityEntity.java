package com.example.microservices.jwt_authentication.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "University")
public class UniversityEntity implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String uname;
    private String address;
}
