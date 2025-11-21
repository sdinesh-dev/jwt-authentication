package com.example.microservices.jwt_authentication.jwtpack;

import com.example.microservices.jwt_authentication.dao.UserDataRepository;
import com.example.microservices.jwt_authentication.dao.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UserDataRepository userDataRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userDataRepository.findByUsername(username);
        System.out.println("userEntity:" + userEntity);
        if (userEntity != null) {
            Collection<String> mappedAuthorities = Arrays.asList(userEntity.getRole().split(","));
            //if not using role based authentication, we can pass empty List instead of mappedAuthorities
            return new User(username, new BCryptPasswordEncoder().encode(userEntity.getPassword()), mappedAuthorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
