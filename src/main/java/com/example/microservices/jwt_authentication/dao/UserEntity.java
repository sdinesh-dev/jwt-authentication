package com.example.microservices.jwt_authentication.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="UserData")
public class UserEntity implements Serializable, GrantedAuthority {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private String role;
    @Override
    public String getAuthority() {
        return this.role;
    }
}
