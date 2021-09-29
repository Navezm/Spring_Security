package com.example.springsecurity.services.user;

import com.example.springsecurity.entities.User;
import com.example.springsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return this.repository.findAll();
    }

    @Override
    public User findById(Long id) {
        if (this.repository.findById(id).isPresent()) return this.repository.findById(id).get();
        else return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return this.repository.findByUsername(s);
    }
}
