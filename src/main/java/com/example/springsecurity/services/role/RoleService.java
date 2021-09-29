package com.example.springsecurity.services.role;

import com.example.springsecurity.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role findById(Long id);
}
