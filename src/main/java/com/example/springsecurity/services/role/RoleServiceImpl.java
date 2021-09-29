package com.example.springsecurity.services.role;

import com.example.springsecurity.entities.Role;
import com.example.springsecurity.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository){
        this.repository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Role findById(Long id) {
        if (this.repository.findById(id).isPresent()) return this.repository.findById(id).get();
        else return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return this.repository.findByLabel(s);
    }
}
