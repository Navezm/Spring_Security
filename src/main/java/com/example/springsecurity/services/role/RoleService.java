package com.example.springsecurity.services.role;

import com.example.springsecurity.entities.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface RoleService extends UserDetailsService {
    List<Role> findAll();

    Role findById(Long id);
}
