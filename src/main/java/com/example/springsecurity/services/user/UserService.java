package com.example.springsecurity.services.user;

import com.example.springsecurity.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> findAll();

    User findById(Long id);
}
